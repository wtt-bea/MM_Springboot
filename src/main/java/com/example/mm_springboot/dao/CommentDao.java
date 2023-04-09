package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao {
    // 存储评论信息
    int insertComment(Comment comment);
}
