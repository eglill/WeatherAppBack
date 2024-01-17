package com.eglill.WeatherApp.dto.mapper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherCodeMapper {
    private final Map<Integer, String> weatherCodeToImageLocation = new HashMap<>();

    public WeatherCodeMapper() {
        initializeWeatherCodeToImageLocation();
    }

    private void initializeWeatherCodeToImageLocation() {
        weatherCodeToImageLocation.put(0, "static/warm-sunny.jpg");
        weatherCodeToImageLocation.put(1, "static/warm-sunny.jpg");
        weatherCodeToImageLocation.put(2, "static/warm-partly-cloudy.jpg");
        weatherCodeToImageLocation.put(3, "static/universal-overcast.jpg");
        weatherCodeToImageLocation.put(45, "static/universal-foggy.jpg");
        weatherCodeToImageLocation.put(48, "static/universal-foggy.jpg");
        weatherCodeToImageLocation.put(51, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(53, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(55, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(56, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(57, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(61, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(63, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(65, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(66, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(67, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(71, "static/universal-snowy.jpg");
        weatherCodeToImageLocation.put(73, "static/universal-snowy.jpg");
        weatherCodeToImageLocation.put(75, "static/universal-snowy.jpg");
        weatherCodeToImageLocation.put(77, "static/universal-snowy.jpg");
        weatherCodeToImageLocation.put(80, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(81, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(82, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(85, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(86, "static/universal-rainy.jpg");
        weatherCodeToImageLocation.put(95, "static/universal-lightning.jpg");
        weatherCodeToImageLocation.put(99, "static/universal-lightning.jpg");
    }

    public String getImageLocation(int weatherCode) {
        return weatherCodeToImageLocation.getOrDefault(weatherCode, "static/cold-partly-cloudy.jpg");
    }
}
