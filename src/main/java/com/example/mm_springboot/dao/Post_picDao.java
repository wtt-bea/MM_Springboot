package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Post_pic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Post_picDao {
    // 存储帖子信息
    int insertPic(Post_pic post_pic);
    List<Post_pic> queryImage();
}
