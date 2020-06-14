package com.openweatherapi.search;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import com.openweatherapi.search.entities.WeatherLog;


import java.lang.reflect.Method;

@Component("myCacheKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator {

		@Override
		public Object generate(Object target, Method method, Object... params) {
			StringBuilder sb = new StringBuilder();
			WeatherLog weatherlog = null;
			if (method != null)
				sb.append(method.getName() + "-");
			if (params != null) {
				for (Object param : params) {
					sb.append(param);
				}
				return sb.toString();
			}
			return sb.append("");
		}
}
