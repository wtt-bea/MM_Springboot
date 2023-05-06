package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    int insertPost(Post post);
    List<Post> receive(String planet);
    List<Post> postHome(String account);
    int postlike(String post_id);
    int postunlike(String post_id);
    int postAddcomment(String post_id);

    List<Post> postSearch(String context);
}
