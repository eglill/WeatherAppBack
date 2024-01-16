package com.eglill.WeatherApp.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Location {
    private Double lat;
    private Double lon;
    private String display_name;
}
