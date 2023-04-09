package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Like;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    int insertLike(Like like);
    String queryLike(String post_id, String account);
}
