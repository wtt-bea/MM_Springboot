package com.example.mm_springboot.service.impl;

import com.example.mm_springboot.dao.CommentDao;
import com.example.mm_springboot.model.Comment;
import com.example.mm_springboot.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }
}
