package com.openweatherapi.search.dao;


import com.openweatherapi.search.entities.WeatherLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.openweatherapi.search.Utils.DateUtils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public class WeatherLogImpl implements WeatherLogDao {

	@Value( "${weather.api.key}" )
	private String apiKey;

    @Autowired
	RestTemplate restTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public WeatherLog addWeatherLog(String cityName) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String jsonString = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?q=" +
				   cityName + "&" +
						"units=metric&appid=" + apiKey, HttpMethod.GET, entity, String.class).getBody();
		JSONObject obj = new JSONObject(jsonString);
		WeatherLog weatherLog = new WeatherLog();
		weatherLog.setCity_name(String.valueOf(obj.get("name")));
		weatherLog.setCloudiness(String.valueOf(obj.getJSONArray("weather").getJSONObject(0).get("description")));
		weatherLog.setHumidity(obj.getJSONObject("main").getString("humidity"));
		weatherLog.setTemperature(obj.getJSONObject("main").getString("temp"));
		long seconds = (int) obj.get("dt");
		weatherLog.setTimestamp(seconds);
		weatherLog.setPressure(obj.getJSONObject("main").getString("pressure"));
		weatherLog.setSunrise(Long.valueOf(obj.getJSONObject("sys").getString("sunrise")));
		weatherLog.setSunset(Long.valueOf(obj.getJSONObject("sys").getString("sunset")));
		weatherLog.setWindSpeed(obj.getJSONObject("wind").getString("speed"));
		Session session = this.sessionFactory.getCurrentSession();
		session.save(weatherLog);
		return weatherLog;
	}

	@Override
	public WeatherLog updateWeatherData(String cityName) {
		return null;
	}

	@Override
	public List<WeatherLog> getAllWeatherData() {
		Session session = this.sessionFactory.getCurrentSession();
		List<WeatherLog> weatherLogList = session.createQuery("from WeatherLog").list();
		return weatherLogList;
	}


	@Override
	public List<WeatherLog> getWeatherDataByCityNameAndDate(String cityName, String dateSearch) throws ParseException {
		long seconds = DateUtils.datetoSeconds(dateSearch);
		return sessionFactory.getCurrentSession().createQuery(
				"from WeatherLog where city_name = '" + cityName + "' and timestamp >= " + seconds +
						" and timestamp " + "<= " + (seconds + 86400)).list();

	}

	@Override
	public List<WeatherLog> getWeatherDataByCityName(String cityName) {
		return sessionFactory.getCurrentSession().createQuery(
				"from WeatherLog where city_name = '" + cityName + "'").list();

	}

	@Override
	public WeatherLog deleteWeatherDataById(int id) {
		Session session = sessionFactory.getCurrentSession();
		WeatherLog weatherLog = (WeatherLog) session.get(WeatherLog.class,id);
		session.delete(weatherLog);
		return weatherLog;
	}
}
