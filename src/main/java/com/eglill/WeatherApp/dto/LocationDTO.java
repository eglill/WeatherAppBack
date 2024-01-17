package com.eglill.WeatherApp.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LocationDTO {
    private Double latitude;
    private Double longitude;
    private String name;
}
