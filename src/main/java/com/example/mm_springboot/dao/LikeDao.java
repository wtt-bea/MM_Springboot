package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeDao {
    // 存储帖子信息
    int insertLike(Like like);
}
