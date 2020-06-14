package com.openweatherapi.search.service;

import java.text.ParseException;
import java.util.List;
import com.openweatherapi.search.dao.WeatherLogDao;
import com.openweatherapi.search.entities.WeatherLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@CacheConfig(cacheNames = "WeatherCache")
public class WeatherLogService {

	@Autowired
    WeatherLogDao weatherLogDao;

	@javax.transaction.Transactional
	public List<WeatherLog> getAllWeatherData() {
		return weatherLogDao.getAllWeatherData();
	}

	@javax.transaction.Transactional
	public List<WeatherLog> getWeatherDataByCityNameAndDate(String city_name, String date) throws ParseException {
		return weatherLogDao.getWeatherDataByCityNameAndDate(city_name,date);
	}

	@javax.transaction.Transactional
	public List<WeatherLog> getWeatherDataByCityName(String cityName){
		return weatherLogDao.getWeatherDataByCityName(cityName);

	}


	@javax.transaction.Transactional
	public WeatherLog addWeatheData(String cityName) throws Exception {

		return this.weatherLogDao.addWeatherLog(cityName);
	}

}
