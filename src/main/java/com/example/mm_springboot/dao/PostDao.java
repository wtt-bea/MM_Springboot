package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostDao {
    // 存储帖子信息
    int insertPost(Post post);
    List<Post> receive(@Param("planet") String planet);

    List<Post> postHome(@Param("account") String account);
    int postlike(@Param("post_id") String post_id);
    int postunlike(@Param("post_id") String post_id);
    int postAddcomment(@Param("post_id") String post_id);
    List<Post> postSearch(@Param("context") String context);
}
