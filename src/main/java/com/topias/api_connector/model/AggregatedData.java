package com.topias.api_connector.model;


import java.util.ArrayList;


public class AggregatedData {
    private WeatherData weather;
    private ArrayList<NewsData> news;

    public AggregatedData(ArrayList<NewsData> news, WeatherData weather) {
        this.weather = weather;
        this.news = news;
    }

    public ArrayList<NewsData> getNews() {
        return news;
    }

    public WeatherData getWeather() {
        return weather;
    }

}
