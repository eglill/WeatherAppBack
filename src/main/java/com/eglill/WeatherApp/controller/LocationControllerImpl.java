package com.eglill.WeatherApp.controller;

import com.eglill.WeatherApp.controller.contract.LocationController;
import com.eglill.WeatherApp.dto.LocationDTO;
import com.eglill.WeatherApp.dto.mapper.LocationMapper;
import com.eglill.WeatherApp.service.LocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/location")
public class LocationControllerImpl implements LocationController {

    private final LocationServiceImpl locationService;
    private final LocationMapper locationMapper;
    private final ApiResponseBuilder<LocationDTO> response;

    @Override
    @GetMapping()
    public ResponseEntity<List<LocationDTO>> getLocation(
            @RequestParam String query,
            @RequestParam Integer limit) {
        return response.getResponseEntity(
                locationMapper.toDto(locationService.getLocation(query, limit)),
                HttpStatus.OK);
    }
}
