package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.PostDao;
import com.example.mm_springboot.model.Post;
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
    public List<Post> receive(String planet) {
        return postDao.receive(planet);
    }

    @Override
    public List<Post> postHome(String account) {
        return postDao.postHome(account);
    }

    @Override
    public int postlike(String post_id){return postDao.postlike(post_id);}

    @Override
    public int postunlike(String post_id){return postDao.postunlike(post_id);}

    @Override
    public int postAddcomment(String post_id) {
        return postDao.postAddcomment(post_id);
    }
}
