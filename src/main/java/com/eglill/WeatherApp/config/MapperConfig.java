package com.eglill.WeatherApp.config;

import com.eglill.WeatherApp.dto.DayDTO;
import com.eglill.WeatherApp.dto.LocationDTO;
import com.eglill.WeatherApp.dto.WeatherDTO;
import com.eglill.WeatherApp.model.Days;
import com.eglill.WeatherApp.model.Location;
import com.eglill.WeatherApp.model.Weather;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Days, DayDTO[]> daysConverter = ctx -> {
            Days source = ctx.getSource();
            if (source == null) {
                return null;
            }

            List<String> timeList = Arrays.asList(source.getTime());
            List<Integer> weatherCodeList = Arrays.asList(source.getWeather_code());
            List<Double> maxTemperatureList = Arrays.asList(source.getTemperature_2m_max());
            List<Double> minTemperatureList = Arrays.asList(source.getTemperature_2m_min());

            int size = Math.min(
                    Math.min(timeList.size(), weatherCodeList.size()),
                    Math.min(maxTemperatureList.size(), minTemperatureList.size())
            );

            DayDTO[] dayDTOArray = new DayDTO[size];
            for (int i = 0; i < size; i++) {
                DayDTO dayDTO = new DayDTO();
                dayDTO.setTime(timeList.get(i));
                dayDTO.setWeatherCode(weatherCodeList.get(i));
                dayDTO.setMaxTemperature(maxTemperatureList.get(i));
                dayDTO.setMinTemperature(minTemperatureList.get(i));
                dayDTOArray[i] = dayDTO;
            }

            return dayDTOArray;
        };

        modelMapper.addConverter(daysConverter);

        TypeMap<Weather, WeatherDTO> weatherMap = modelMapper.createTypeMap(Weather.class, WeatherDTO.class)
                .addMappings(
                        mapper -> mapper.using(daysConverter).map(Weather::getDaily, WeatherDTO::setDays)
                );

        TypeMap<Location, LocationDTO> locationMap = modelMapper.createTypeMap(Location.class, LocationDTO.class)
                .addMappings(
                        mapper -> {
                            mapper.map(Location::getLat, LocationDTO::setLatitude);
                            mapper.map(Location::getLon, LocationDTO::setLongitude);
                            mapper.map(Location::getDisplay_name, LocationDTO::setName);
                        }
                );

        return modelMapper;
    }
}
