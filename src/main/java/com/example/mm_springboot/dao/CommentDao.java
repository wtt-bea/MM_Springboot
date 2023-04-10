package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {
    // 存储评论信息
    int insertComment(Comment comment);

    List<Comment> queryComment(@Param("post_id") String post_id);
}
