package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Post_pic;
import org.springframework.stereotype.Service;

@Service
public interface Post_picService {
    int insertPic(Post_pic post_pic);

}
