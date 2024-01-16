package com.eglill.WeatherApp.service.contract;

import com.eglill.WeatherApp.model.Weather;

public interface WeatherService {
    Weather getWeatherByCoords(Double latitude, Double longitude);
}
