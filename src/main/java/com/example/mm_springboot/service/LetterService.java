package com.example.mm_springboot.service;

import com.example.mm_springboot.model.Letter;
import com.example.mm_springboot.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LetterService {
    int insertLetter(Letter letter);
    List<Letter> queryLetter(String recipient);
    Letter queryOneLetter(String account);
    int insertRecipient(int letter_id, String account);
}
