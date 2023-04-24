package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.Letter;
import com.example.mm_springboot.service.LetterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class letterController {
    @Resource
    public LetterService letterService;

    /**
     * 写信
     * @param account
     * @param stamp
     * @param recipient
     * @param context
     * @return
     */
    @RequestMapping("/letter/insertLetter")
    public CommonResult insertLetter(@RequestParam("account") String account,@RequestParam("stamp") String stamp,@RequestParam("recipient") String recipient, @RequestParam("context") String context) {
        Letter letter = new Letter();
        letter.setAccount(account);
        letter.setStamp(stamp);
        letter.setRecipient(recipient);
        letter.setContext(context);
        // 获取当前时间并格式化获取系统时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String currentTime = sf.format(now.getTime());
        letter.setDate(currentTime);
        int res = 0;
        try {
            res = letterService.insertLetter(letter);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            return new CommonResult(401, "false");
        }
    }

    /**
     * 获取所有信
     * @param recipient
     * @return 所有信
     */
    @RequestMapping("/letter/queryLetter")
    public CommonResult queryLetter(@RequestParam("recipient") String recipient) {
        List<Letter> res = null;
        try {
            res = letterService.queryLetter(recipient);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (res != null) {
            return new CommonResult(200, "true", res);
        }else{
            return new CommonResult(401, "false");
        }
    }

    /**
     * 获取一封信
     * @param account
     * @return 一封信
     */
    @RequestMapping("/letter/queryOneLetter")
    public CommonResult queryOneLetter(@RequestParam("account") String account) {
        Letter res = null;
        try {
            res = letterService.queryOneLetter(account);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (res != null) {
            return new CommonResult(200, "true", res);
        }else{
            return new CommonResult(401, "false");
        }
    }

    /**
     * 更改收信人
     * @param letter_id
     * @param account
     * @return
     */
    @RequestMapping("/letter/insertRecipient")
    public CommonResult insertRecipient(@RequestParam("letter_id") int letter_id,@RequestParam("account") String account) {
        int res = 0;
        try {
            res = letterService.insertRecipient(letter_id, account);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            System.out.println("insertRecipient"+res);
            return new CommonResult(401, "false");
        }
    }


}

