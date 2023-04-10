package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.LikeDao;
import com.example.mm_springboot.model.Like;
import com.example.mm_springboot.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeDao likeDao;

    @Override
    public int insertLike(Like like) {
        return likeDao.insertLike(like);
    }

    @Override
    public int deleteLike(String post_id, String account) {
        return likeDao.deleteLike(post_id,account);
    }

    @Override
    public List<Like> queryLike(String account) {
        return likeDao.queryLike(account);
    }
}
