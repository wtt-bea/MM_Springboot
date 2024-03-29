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
    User queryPlanet(@Param("account") String account);
    User queryuserInfo(@Param("account") String account);
    int updateUser(@Param("account") String account, @Param("name") String name, @Param("planet") String planet, @Param("address") String address,@Param("visitPath") String visitPath);
    int updateUsers(@Param("account") String account, @Param("name") String name, @Param("planet") String planet, @Param("address") String address);
    User isClock(@Param("account") String account);
    int updateClock(@Param("account") String account);
    int updateScore(@Param("account") String account,@Param("score") int score);
    User queryScore(@Param("account") String account);
    User queryPoint(@Param("account") String account);
    int addPoint(@Param("account") String account,@Param("point") int point);
    int subPoint(@Param("account") String account,@Param("point") int point);
    int updateMood(@Param("account") String account,@Param("mood") int mood);
    User queryMood(@Param("account") String account);
}
