package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Post;
import com.example.mm_springboot.model.PostExt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    int insertPost(Post post);

    List<PostExt> receive(String planet);

    int postlike(String post_id);
    int postunlike(String post_id);
}
