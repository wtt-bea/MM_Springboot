package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    int insertComment(Comment comment);

}
