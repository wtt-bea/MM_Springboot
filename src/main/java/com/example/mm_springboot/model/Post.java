package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
    private String post_id;
    private String account;
    private String date;
    private String context;
    private int like_number;
    private int comment_number;
    private String name;
    private int mood;

    public Post(String post_id, String account, String date, String context, int like_number,int comment_number) {
        this.post_id = post_id;
        this.account = account;
        this.date = date;
        this.context = context;
        this.like_number = like_number;
        this.comment_number = comment_number;
    }
}
