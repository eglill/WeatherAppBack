package com.eglill.WeatherApp.controller;

import com.eglill.WeatherApp.controller.contract.WeatherController;
import com.eglill.WeatherApp.dto.WeatherDTO;
import com.eglill.WeatherApp.dto.mapper.WeatherMapper;
import com.eglill.WeatherApp.service.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/weather")
public class WeatherControllerImpl implements WeatherController {

    private final WeatherServiceImpl weatherService;
    private final WeatherMapper weatherMapper;
    private final ApiResponseBuilder<WeatherDTO> response;

    @Override
    @GetMapping()
    public ResponseEntity<WeatherDTO> getSevenDayWeatherInfo(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        return response.getResponseEntity(
                weatherMapper.toDto(weatherService.getWeatherByCoords(latitude, longitude)),
                HttpStatus.OK);
    }
}
