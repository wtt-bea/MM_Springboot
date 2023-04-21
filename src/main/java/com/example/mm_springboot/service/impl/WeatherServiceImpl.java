package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.WeatherDao;
import com.example.mm_springboot.model.Weather;
import com.example.mm_springboot.service.WeatherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Resource
    private WeatherDao weatherDao;

    @Override
    public Weather queryWeather(String planet){return weatherDao.queryWeather(planet);}
}
