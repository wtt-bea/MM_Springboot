package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeatherDao {
    Weather queryWeather(@Param("planet") String planet);
}
