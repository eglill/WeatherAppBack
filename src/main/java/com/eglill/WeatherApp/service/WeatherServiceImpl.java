package com.eglill.WeatherApp.service;

import com.eglill.WeatherApp.model.Weather;
import com.eglill.WeatherApp.service.contract.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather getWeatherByCoords(Double latitude, Double longitude) {
        return restTemplate.getForObject(
                "https://api.open-meteo.com/v1/forecast?latitude=" +
                        latitude +
                        "&longitude=" +
                        longitude +
                        "&daily=weather_code,temperature_2m_max,temperature_2m_min",
                Weather.class
        );
    }
}