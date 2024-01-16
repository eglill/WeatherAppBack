package com.eglill.WeatherApp.dto.mapper.contract;

import java.util.List;

public interface BaseMapper<In, Out> {
    Out toDto(In model);
    List<Out> toDto(List<In> models);
}
