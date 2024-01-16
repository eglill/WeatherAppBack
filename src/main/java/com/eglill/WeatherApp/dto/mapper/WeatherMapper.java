package com.eglill.WeatherApp.dto.mapper;

import com.eglill.WeatherApp.dto.WeatherDTO;
import com.eglill.WeatherApp.dto.mapper.contract.BaseMapper;
import com.eglill.WeatherApp.model.Weather;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper implements BaseMapper<Weather, WeatherDTO> {

    ModelMapper modelMapper;

    @Autowired
    public WeatherMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WeatherDTO toDto(Weather weather) {
        return modelMapper.map(weather, WeatherDTO.class);
    }

    @Override
    public List<WeatherDTO> toDto(List<Weather> models) {
        return models.stream().map(this::toDto).collect(Collectors.toList());
    }
}
