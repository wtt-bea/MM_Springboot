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


    public Letter(int letter_id, String account, String stamp, String recipient, String context) {
        this.letter_id = letter_id;
        this.account = account;
        this.stamp = stamp;
        this.recipient = recipient;
        this.context = context;
    }
}
