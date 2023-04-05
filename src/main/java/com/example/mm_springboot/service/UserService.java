package com.example.mm_springboot.service;

import com.example.mm_springboot.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User queryUser(String account, String password);

    int insertUser(User user);

    User queryPlanet(String account);

}
