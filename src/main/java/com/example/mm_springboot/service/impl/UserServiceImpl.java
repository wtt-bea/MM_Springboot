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

    @Override
    public User queryPlanet(String account) {
        return userDao.queryPlanet(account);
    }

    @Override
    public User queryuserInfo(String account) {
        return userDao.queryuserInfo(account);
    }

    @Override
    public int updateUser(String account, String name, String planet, String address, String visitPath) {
        return userDao.updateUser(account,name,planet,address,visitPath);
    }

    @Override
    public int updateUsers(String account, String name, String planet, String address) {
        return userDao.updateUsers(account,name,planet,address);
    }

    @Override
    public User isClock(String account){
        return userDao.isClock(account);
    }

    @Override
    public int updateClock(String account){
        return userDao.updateClock(account);
    }

    @Override
    public int updateScore(String account, int score) {
        return userDao.updateScore(account, score);
    }

    @Override
    public User queryScore(String account) {
        return userDao.queryScore(account);
    }

}
