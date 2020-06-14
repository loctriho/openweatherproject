package com.openweatherapi.search.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.openweatherapi.search.entities.WeatherLog;
import com.openweatherapi.search.service.WeatherLogService;

import java.text.ParseException;

@Controller
@CacheConfig(cacheNames = "WeatherCache")
public class WeatherDataController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CacheManager cacheManager;

    @Value( "${weather.api.key}" )
    private String apiKey;

    @Autowired
    private WeatherLogService weatherLogService;

    @RequestMapping(value="/archive")
    public String getArchiveData(){
        return "archive";
    }


    @RequestMapping(value={"/", "/weatherData-list"})
    public String listCustomer(Model model) throws JSONException, ParseException, JsonProcessingException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if (hasAdminRole) {
            model.addAttribute("admin", "exist");
        }
        return "weather";
    }

    @Cacheable
    @RequestMapping(value="/getData",method = RequestMethod.GET)
    public @ResponseBody String searchWeatherData(@RequestParam(value = "city_name", required = false,defaultValue = "London") String cityName) throws Exception {

        WeatherLog weatherLog = weatherLogService.addWeatheData(cityName);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = mapper.writeValueAsString(weatherLog);
        return ajaxResponse;

    }

}
