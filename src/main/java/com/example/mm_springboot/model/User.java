package com.example.mm_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {

    private String avatar;
    private String account;
    private String password;
    private String name;
    private String planet;
    private String address;
    private String age;

    public User(String account, String password, String name, String planet, String address, String age, String avatar) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.planet = planet;
        this.address = address;
        this.age = age;
        this.avatar = avatar;
    }
}
