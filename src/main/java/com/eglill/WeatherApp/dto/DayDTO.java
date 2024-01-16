package com.eglill.WeatherApp.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class DayDTO {
    private String time;
    private Integer weatherCode;
    private Double maxTemperature;
    private Double minTemperature;
}