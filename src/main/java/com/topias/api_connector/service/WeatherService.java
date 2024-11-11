package com.topias.api_connector.service;

import com.topias.api_connector.model.WeatherData;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    Dotenv dotenv = Dotenv.load();

    private final RestTemplate restTemplate;

    private final String apiUrl = "http://api.openweathermap.org/data/2.5/weather";

    private final String apiKey = dotenv.get("WEATHER_API_KEY");

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String city) {
        String url = apiUrl + "?q=" + city + "&units=metric" + "&appid=" + apiKey;

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            return mapWeatherData(response);
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage() );
            return null;
        }
    }

    public WeatherData mapWeatherData(Map<String, Object> data) {
        System.out.println(data);

        if (!isValidWeatherData(data)) {
            return new WeatherData("Unknown", 0.0, 0.0, "Invalid weather data");
        }

        System.out.println(data);

        Map<String, Object> main = (Map<String, Object>) data.get("main");
        List<Map<String, Object>> weather = (List<Map<String, Object>>) data.get("weather");

        String city = (String) data.get("name");
        double temp = ((Number) main.get("temp")).doubleValue();
        double feelsLike = ((Number) main.get("feels_like")).doubleValue();
        String description = (String) weather.get(0).get("description");

        return new WeatherData(city, temp, feelsLike, description);
    }


    private boolean isValidWeatherData(Map<String, Object> data) {
        if (data == null) {
            return false;
        }

        Map<String, Object> main = (Map<String, Object>) data.get("main");
        if (main == null || !(main.get("temp") instanceof Number) || !(main.get("feels_like") instanceof Number)) {
            return false;
        }

        List<Map<String, Object>> weather = (List<Map<String, Object>>) data.get("weather");
        if (weather == null || weather.isEmpty() || !(weather.get(0).get("description") instanceof String)) {
            return false;
        }

        return true;
    }

}
