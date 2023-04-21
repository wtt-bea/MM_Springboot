package com.example.mm_springboot.service.impl;
import com.example.mm_springboot.dao.LetterDao;
import com.example.mm_springboot.model.Letter;
import com.example.mm_springboot.service.LetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LetterServiceImpl implements LetterService {
    @Resource
    private LetterDao letterDao;


    @Override
    public int insertLetter(Letter letter) {
        return letterDao.insertLetter(letter);
    }

    @Override
    public List<Letter> queryLetter(String recipient) {
        return letterDao.queryLetter(recipient);
    }

    @Override
    public Letter queryOneLetter(String account) {
        return letterDao.queryOneLetter(account);
    }

    @Override
    public int insertRecipient(int letter_id, String account) {
        return letterDao.insertRecipient(letter_id, account);
    }
}
