package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
    private String planet;
    private int num;
    private int temperature;

    public Weather(String planet, int num, int temperature){
        this.planet = planet;
        this.num = num;
        this.temperature = temperature;
    }
}
