package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeDao {
    // 存储点赞信息
    int insertLike(Like like);

    //删除点赞信息
    int deleteLike(@Param("post_id") String post_id, @Param("account")String account);

    //查询点赞信息
    List<Like> queryLike(@Param("account") String account);
}
