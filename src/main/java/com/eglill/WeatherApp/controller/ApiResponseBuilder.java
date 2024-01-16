package com.eglill.WeatherApp.controller;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class ApiResponseBuilder<T> {

    public ResponseEntity<List<T>> getResponseEntity(
            List<T> items, HttpStatus status) {
        return new ResponseEntity<>(items, status);
    }
    public ResponseEntity<T> getResponseEntity(
            T item, HttpStatus status) {
        return new ResponseEntity<>(item, status);
    }

    public ResponseEntity<HttpStatus> getResponseEntity(HttpStatus status) {
        return new ResponseEntity<>(status);
    }
}
