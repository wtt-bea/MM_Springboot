package com.example.mm_springboot.service;

import com.example.mm_springboot.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User queryUser(String account, String password);

    int insertUser(User user);

    User queryPlanet(String account);

    User queryuserInfo(String account);

    int updateUser(String account, String name, String planet, String address, String visitPath);

    User isClock(String account);

    int updateClock(String account);
}
