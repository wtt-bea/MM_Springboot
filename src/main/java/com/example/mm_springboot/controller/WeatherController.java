package com.example.mm_springboot.controller;
import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.Weather;
import com.example.mm_springboot.service.WeatherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WeatherController {
    @Resource
    private WeatherService weatherService;

    /**
     * 查询用户星球天气
     * @param planet 星球
     * @return 返回天气
     */
    @RequestMapping("/weather/weatherquery")
    public CommonResult<String> queryWeather(@RequestParam("planet") String planet) {
        Weather weather = weatherService.queryWeather(planet);
        if(weather!=null){
            return new CommonResult(200, "true",weather);
        }else{
            return new CommonResult(404, "false");
        }

    }
}

