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
    int updateUsers(String account, String name, String planet, String address);

    User isClock(String account);

    int updateClock(String account);

    int updateScore(String account,int Score);
    User queryScore(String account);
    User queryPoint(String account);
    int addPoint(String account,int point);
    int subPoint(String account,int point);
    User queryMood(String account);
    int updateMood(String account, int mood);
}
