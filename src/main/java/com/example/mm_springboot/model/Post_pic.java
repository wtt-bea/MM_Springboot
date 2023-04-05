package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post_pic {

    private String pic_id;
    private String post_id;
    private String url;


    public Post_pic(String pic_id, String post_id, String url) {
        this.pic_id = pic_id;
        this.post_id = post_id;
        this.url = url;
    }
}
