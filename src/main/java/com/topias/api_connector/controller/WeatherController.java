package com.topias.api_connector.controller;

import com.topias.api_connector.model.WeatherData;
import com.topias.api_connector.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherData weather(@RequestParam String city) {
        return weatherService.getWeatherData(city);
    }

}
