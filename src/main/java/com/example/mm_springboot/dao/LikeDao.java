package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeDao {
    // 存储点赞信息
    int insertLike(Like like);
    String queryLike(@Param("post_id") String post_id, @Param("account") String account);
}
