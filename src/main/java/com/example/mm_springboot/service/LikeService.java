package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    int insertLike(Like like);
    int deleteLike(String post_id, String account);
    List<Like> queryLike(String account);
}
