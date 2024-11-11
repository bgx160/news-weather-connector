package com.topias.api_connector.service;

import com.topias.api_connector.model.AggregatedData;
import com.topias.api_connector.model.NewsData;
import com.topias.api_connector.model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AggregatorService {

    private final NewsService newsService;
    private final WeatherService weatherService;

    public AggregatorService(NewsService newsService, WeatherService weatherService) {
        this.newsService = newsService;
        this.weatherService = weatherService;
    }

    public AggregatedData getData(String city) {
        city = (city == null || city.isEmpty()) ? "helsinki" : city;
        int pageSize = 15;

        ArrayList<NewsData> newsData = newsService.getNewsData(city, 15);
        WeatherData weatherData = weatherService.getWeatherData(city);

        return new AggregatedData(newsData, weatherData);
    }

}
