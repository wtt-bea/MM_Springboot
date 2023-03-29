package com.example.mm_springboot.service.impl;

import com.example.mm_springboot.dao.UserDao;
import com.example.mm_springboot.model.User;
import com.example.mm_springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryUser(String account, String password) {
        return userDao.queryUser(account, password);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
