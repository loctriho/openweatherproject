package com.openweatherapi.search.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "WeatherDataLog")
public class WeatherLog implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Column(name="city_name")
	String city_name;



	@Override
	public int hashCode() {
		return Objects.hash(city_name, temperature, cloudiness, windSpeed, humidity, pressure, sunset, sunrise);
	}

	@Column(name="temperature")
	String temperature;

	@Column(name="cloudiness")
	String cloudiness;


	@Column(name="windspeed")
	String windSpeed;

	@Column(name="humidity")
	String humidity;

	@Column(name="pressure")
	String pressure;

	@Column(name="sunset")
	long sunset;

	@Column(name="sunrise")
	long sunrise;

	@Column(name="temp_timestamp")
	long timestamp;

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(String cloudiness) {
		this.cloudiness = cloudiness;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WeatherLog that = (WeatherLog) o;
		return	sunset == that.sunset &&
				sunrise == that.sunrise &&
				city_name.equals(that.city_name) &&
				temperature.equals(that.temperature) &&
				cloudiness.equals(that.cloudiness) &&
				windSpeed.equals(that.windSpeed) &&
				humidity.equals(that.humidity) &&
				pressure.equals(that.pressure);
	}

}
