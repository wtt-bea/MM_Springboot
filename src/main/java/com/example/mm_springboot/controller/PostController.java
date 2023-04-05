package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.Post;
import com.example.mm_springboot.model.PostExt;
import com.example.mm_springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class PostController {
    @Resource
    public PostService postService;

    /**
     * 发帖
     * @param post_id
     * @param account
     * @param context
     * @return
     */
    @RequestMapping("/post/posttext")
    public CommonResult Posttext(@RequestParam("post_id") String post_id, @RequestParam("account") String account, @RequestParam("context") String context) {
        Post post = new Post();
        post.setPost_id(post_id);
        post.setAccount(account);
        post.setContext(context);
        post.setLike_number(0);
        post.setComment_number(0);
        // 获取当前时间并格式化获取系统时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String currentTime = sf.format(now.getTime());
        post.setDate(currentTime);

        int res = 0;
        try {
            res = postService.insertPost(post);
            System.out.println("jia"+res);
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
     * 获取所有帖
     * @param planet
     * @return 所有帖子
     */
    @RequestMapping("/post/receive")
    public CommonResult receive(@RequestParam("planet") String planet) {
        List<PostExt> res = null;
        try {
            res = postService.receive(planet);
            System.out.println("ducedd" + res);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (res != null) {
            return new CommonResult(200, "true", res);
        }else{
            return new CommonResult(401, "false");
        }

    }
}

