package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String avatar;
    private String account;
    private String password;
    private String name;
    private String planet;
    private String address;
    private String age;
    private int clock;
    private int clocktime;
    private int score;

    public User(String account, String password, String name, String planet, String address, String age, String avatar, int clock, int clocktime, int score) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.planet = planet;
        this.address = address;
        this.age = age;
        this.avatar = avatar;
        this.clock = clock;
        this.clocktime = clocktime;
        this.score = score;
    }
}
