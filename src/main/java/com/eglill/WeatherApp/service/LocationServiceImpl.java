package com.eglill.WeatherApp.service;

import com.eglill.WeatherApp.model.Location;
import com.eglill.WeatherApp.service.contract.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private RestTemplate restTemplate;

    @Autowired
    public LocationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Location> getLocation(String query, Integer limit) {
        Location[] locations = restTemplate.getForObject(
                "https://nominatim.openstreetmap.org/search?q=" +
                        query +
                        "&format=json&limit=" +
                        limit,
                Location[].class
        );
        if (locations == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(locations);
    }
}