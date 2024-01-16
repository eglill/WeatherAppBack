package com.eglill.WeatherApp.controller.contract;

import com.eglill.WeatherApp.dto.WeatherDTO;
import org.springframework.http.ResponseEntity;

public interface WeatherController {
    ResponseEntity<WeatherDTO> getSevenDayWeatherInfo(Double latitude, Double longitude);
}
