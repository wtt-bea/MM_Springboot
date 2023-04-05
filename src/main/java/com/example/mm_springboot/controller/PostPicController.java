package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.Post_pic;
import com.example.mm_springboot.service.Post_picService;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
public class PostPicController {
    @Resource
    public Post_picService post_picService;

    /**
     * 储存图片
     * @param pic_id
     * @param post_id
     * @return
     */
    @RequestMapping("/post_pic/pic")
    public CommonResult Pic(@RequestParam("pic_id") String pic_id, @RequestParam("post_id") String post_id, @RequestParam("file")MultipartFile file) {
        Post_pic post_pic = new Post_pic();
        post_pic.setPic_id(pic_id);
        post_pic.setPost_id(post_id);

        //储存图片
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();

        String url_path = "images" + File.separator + fileName;

        String savePath = staticPath + File.separator + url_path;
        File saveFile = new File(savePath);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        try{
            file.transferTo(saveFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        post_pic.setUrl(url_path);


        int res = 0;
        try {
            res = post_picService.insertPic(post_pic);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            return new CommonResult(401, "false");
        }
    }
}
