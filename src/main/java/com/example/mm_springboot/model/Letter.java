package com.example.mm_springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Letter {
    private int letter_id;
    private String account;
    private String stamp;
    private String recipient;
    private String context;
    private String date;
    private String name;


    public Letter(int letter_id, String account, String stamp, String recipient, String context, String date) {
        this.letter_id = letter_id;
        this.account = account;
        this.stamp = stamp;
        this.recipient = recipient;
        this.context = context;
        this.date = date;
    }
}
