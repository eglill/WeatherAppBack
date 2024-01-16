package com.eglill.WeatherApp.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Days {
    private String[] time;
    private Integer[] weather_code;
    private Double[] temperature_2m_max;
    private Double[] temperature_2m_min;
}