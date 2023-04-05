package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.PostDao;
import com.example.mm_springboot.model.Post;
import com.example.mm_springboot.model.PostExt;
import com.example.mm_springboot.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;

    @Override
    public int insertPost(Post post) {
        return postDao.insertPost(post);
    }

    @Override
    public List<PostExt> receive(String planet) {
        return postDao.receive(planet);
    }
}
