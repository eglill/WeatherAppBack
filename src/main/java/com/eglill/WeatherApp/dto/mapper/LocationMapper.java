package com.eglill.WeatherApp.dto.mapper;

import com.eglill.WeatherApp.dto.LocationDTO;
import com.eglill.WeatherApp.dto.mapper.contract.BaseMapper;
import com.eglill.WeatherApp.model.Location;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper implements BaseMapper<Location, LocationDTO> {

    ModelMapper modelMapper;

    public LocationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationDTO toDto(Location location) {
        return modelMapper.map(location, LocationDTO.class);
    }

    @Override
    public List<LocationDTO> toDto(List<Location> locations) {
        return locations.stream().map(this::toDto).collect(Collectors.toList());
    }
}
