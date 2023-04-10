package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Post;
import com.example.mm_springboot.model.PostExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostDao {
    // 存储帖子信息
    int insertPost(Post post);
    List<PostExt> receive(@Param("planet") String planet);

    int postlike(@Param("post_id") String post_id);
    int postunlike(@Param("post_id") String post_id);
}
