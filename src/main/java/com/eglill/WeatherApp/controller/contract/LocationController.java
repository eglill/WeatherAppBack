package com.eglill.WeatherApp.controller.contract;

import com.eglill.WeatherApp.dto.LocationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationController {
    ResponseEntity<List<LocationDTO>> getLocation(String query, Integer limit);

}
