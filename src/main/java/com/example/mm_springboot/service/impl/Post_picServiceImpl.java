package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.Post_picDao;
import com.example.mm_springboot.model.Like;
import com.example.mm_springboot.model.Post_pic;
import com.example.mm_springboot.service.LikeService;
import com.example.mm_springboot.service.Post_picService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Post_picServiceImpl implements Post_picService {
    @Resource
    private Post_picDao post_picDao;

    @Override
    public int insertPic(Post_pic post_pic) {
        return post_picDao.insertPic(post_pic);
    }

    public List<Post_pic> queryImage(){ return post_picDao.queryImage();}
}
