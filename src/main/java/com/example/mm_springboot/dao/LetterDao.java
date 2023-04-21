package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.Letter;
import com.example.mm_springboot.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LetterDao {
    // 存储帖子信息
    int insertLetter(Letter letter);
    //获取所有信
    List<Letter> queryLetter(@Param("recipient") String recipient);
    //获取新信
    Letter queryOneLetter(@Param("account") String account);
    //新增收信人
    int insertRecipient(@Param("letter_id") int letter_id, @Param("account") String account);

}
