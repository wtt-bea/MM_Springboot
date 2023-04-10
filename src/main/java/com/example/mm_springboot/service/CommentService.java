package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Comment;
import com.example.mm_springboot.model.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    int insertComment(Comment comment);
    List<Comment> queryComment(String post_id);


}
