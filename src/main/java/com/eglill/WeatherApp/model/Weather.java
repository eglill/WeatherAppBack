package com.eglill.WeatherApp.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Weather {
    private Double  latitude;
    private Double longitude;
    private String timezone;
    private Days daily;
}