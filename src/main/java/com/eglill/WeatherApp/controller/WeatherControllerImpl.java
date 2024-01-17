package com.eglill.WeatherApp.controller;

import com.eglill.WeatherApp.controller.contract.WeatherController;
import com.eglill.WeatherApp.dto.WeatherDTO;
import com.eglill.WeatherApp.dto.mapper.WeatherCodeMapper;
import com.eglill.WeatherApp.dto.mapper.WeatherMapper;
import com.eglill.WeatherApp.service.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/weather")
public class WeatherControllerImpl implements WeatherController {

    private final WeatherServiceImpl weatherService;
    private final WeatherMapper weatherMapper;
    private final WeatherCodeMapper weatherCodeMapper;
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

    @GetMapping(path = "/image/{weatherCode}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable Integer weatherCode) throws IOException {
        Resource resource = new ClassPathResource(weatherCodeMapper.getImageLocation(weatherCode));
        InputStream inputStream = resource.getInputStream();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(inputStream));
    }
}
