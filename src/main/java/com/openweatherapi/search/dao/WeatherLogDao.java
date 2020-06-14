package com.openweatherapi.search.dao;

import com.openweatherapi.search.entities.WeatherLog;

import java.text.ParseException;
import java.util.List;




public interface WeatherLogDao {


	public WeatherLog addWeatherLog(String cityName) throws Exception;
	public WeatherLog updateWeatherData(String cityName);
	public List<WeatherLog> getAllWeatherData() ;
	public List<WeatherLog> getWeatherDataByCityNameAndDate(String cityName, String date) throws ParseException;
	public List<WeatherLog> getWeatherDataByCityName(String cityName);
	public WeatherLog deleteWeatherDataById(int id);



}
