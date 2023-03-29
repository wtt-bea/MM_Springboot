package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    // 存储用户
    int insertUser(User user);
    // 根据用户名和密码查询用户是否存在
    User queryUser(@Param("account") String account, @Param("password")String password);
}
