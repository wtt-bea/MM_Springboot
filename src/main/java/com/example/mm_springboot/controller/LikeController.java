package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.*;
import com.example.mm_springboot.service.LikeService;
import com.example.mm_springboot.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class LikeController {
    @Resource
    public LikeService likeService;

    /**
     * 点赞
     * @param post_id
     * @param account
     * @return
     */
    @RequestMapping("/like/insertLike")
    public CommonResult insertLike(@RequestParam("post_id") String post_id, @RequestParam("account") String account) {
        Like like = new Like();
        like.setPost_id(post_id);
        like.setAccount(account);
        int res = 0;
        try {
            res = likeService.insertLike(like);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            System.out.println("insertlike"+res);
            return new CommonResult(401, "false");
        }
    }

    /**
     * 取消赞
     * @param post_id
     * @param account
     * @return
     */
    @RequestMapping("/like/deleteLike")
    public CommonResult deleteLike(@RequestParam("post_id") String post_id, @RequestParam("account") String account) {
        int res = 0;
        try {
            res = likeService.deleteLike(post_id, account);
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
     * 查询是否点赞
     * @param account
     * @return 返回所有点赞列表
     */
    @RequestMapping("/like/queryLike")
    public CommonResult queryLike(@RequestParam("account") String account) {
        List<Like> res = null;
        try {
            res = likeService.queryLike(account);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (res != null) {
            return new CommonResult(200, "true",res);
        }else{
            return new CommonResult(401, "false");
        }
    }
}

