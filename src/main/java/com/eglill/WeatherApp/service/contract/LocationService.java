package com.eglill.WeatherApp.service.contract;

import com.eglill.WeatherApp.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getLocation(String query, Integer limit);
}
