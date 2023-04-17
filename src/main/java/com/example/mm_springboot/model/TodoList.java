package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoList {
    private  int list_id;
    private String account;
    private String context;
    private int finish;

    public TodoList(String account, String context, int finish){
        this.account = account;
        this.context = context;
        this.finish = finish;
    };
}
