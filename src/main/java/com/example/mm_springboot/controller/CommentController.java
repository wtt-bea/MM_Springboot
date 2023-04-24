package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.*;
import com.example.mm_springboot.service.CommentService;
import com.example.mm_springboot.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class CommentController {
    @Resource
    public CommentService commentService;

    /**
     * 发评论
     * @param post_id
     * @param account
     * @param context
     * @return
     */
    @RequestMapping("/comment/postComment")
    public CommonResult postComment(@RequestParam("post_id") String post_id, @RequestParam("account") String account, @RequestParam("context") String context) {
        Comment comment = new Comment();
        comment.setPost_id(post_id);
        comment.setAccount(account);
        comment.setContext(context);
        // 获取当前时间并格式化获取系统时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String currentTime = sf.format(now.getTime());
        comment.setDate(currentTime);

        int res = 0;
        try {
            res = commentService.insertComment(comment);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            System.out.println("jiqa"+res);
            return new CommonResult(401, "false");
        }
    }

    /**
     * 查询评论
     * @param post_id
     * @return 返回所有点赞列表
     */
    @RequestMapping("/comment/queryComment")
    public CommonResult queryComment(@RequestParam("post_id") String post_id) {
        List<Comment> res = null;
        try {
            res = commentService.queryComment(post_id);
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

