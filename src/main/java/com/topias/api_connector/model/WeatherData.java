package com.topias.api_connector.model;

public class WeatherData {
    private String city;
    private double temp;
    private double feelsLike;
    private String description;

    public WeatherData(String city, double temp, double feelsLike, String description) {
        this.city = city;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public String getDescription() {
        return description;
    }

}


