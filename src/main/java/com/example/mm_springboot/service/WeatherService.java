package com.example.mm_springboot.service;
import com.example.mm_springboot.model.Weather;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    Weather queryWeather(String planet);
}
