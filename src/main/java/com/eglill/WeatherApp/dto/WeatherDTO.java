package com.eglill.WeatherApp.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class WeatherDTO {
    private Double latitude;
    private Double longitude;
    private String timezone;
    private DayDTO[] days;
}