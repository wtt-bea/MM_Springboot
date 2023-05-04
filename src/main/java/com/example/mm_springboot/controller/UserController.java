package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.User;
import com.example.mm_springboot.service.UserService;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


/**
 * 用户登录
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户登录的方法
     * @param account 账号
     * @param password 密码
     * @return 返回用户登录的结果
     */
    @RequestMapping("/user/login")
    public CommonResult<String> userLogin(@RequestParam("account") String account, @RequestParam("password") String password) {
        User user = userService.queryUser(account, password);

        if(user != null) {
            return new CommonResult(200, "true",user);
        } else {
            return new CommonResult(404, "false");
        }
    }

    String []addresslist1 = {"香格里拉大街", "草木丛林大街", "米卡街道","长安一月街道","苏木街道","东坊街","达尼亚街道","台南街","晨曦街道","田野小镇"};
    String []addresslist2 = {"木易路", "金柳路", "彩虹大道","清幽小道","鲜花盛开路","绿叶繁茂路","法米娜路","泓凡街","美苑路","梵迪珂港口"};
    String []addresslist3 = {"音景佳苑路", "紫霞仙街", "连沛大道","石瑶小道","芝芝路","米米奶酪街","吐司湖","清馨大街","樱桃园","草莓大院"};
    String []addresslist4 = {"漫漫幼儿园路", "玫瑰工坊", "夕阳大道","桃花朵朵街", "幸福小楼", "槐星苑", "亚当研究院","苹果科技路","哒哒街","田子坊"};
    String []addresslist5 = {"可爱熊游乐场","玲玲礼堂街道","西奥教堂街道","圣喵街道","M18街","集美大道","花田小镇","乔乔大桥","暗物质研究所街","番茄大学路"};

    String address="";
    /**
     * 用户注册
     * @param account
     * @param password
     * @param name
     * @param planet
     * @return
     */
    @RequestMapping("/user/register")
    public CommonResult Register(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("planet") String planet, @RequestParam("file") MultipartFile file) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setPlanet(planet);

        // 获取当前时间并格式化设置随机地址
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = simpleDateFormat.format(new Date());
        user.setAge(timeStamp);
        int data_1 = Integer.parseInt (String.valueOf(timeStamp.charAt(11)));
        char data_2 = timeStamp.charAt(12);
        char data_3 = timeStamp.charAt(13);
        if(Objects.equals(planet, "焦虑星")){
            address = "焦虑星" + addresslist1[data_1] + data_2 + data_3 +"号";
        } else if (Objects.equals(planet, "倦怠星")) {
            address = "倦怠星" + addresslist2[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "失落星")) {
            address = "失落星" + addresslist3[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "不开星")) {
            address = "不开星" + addresslist4[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "痛苦星")) {
            address = "痛苦星" + addresslist5[data_1] + data_2 + data_3 +"号";
        }
        user.setAddress(address);

        //储存图片
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();

        String url_path = "images" + File.separator + fileName;

        String savePath = staticPath + File.separator + url_path;

        String visitPath="static/"+url_path;
        File saveFile = new File(savePath);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        try{
            file.transferTo(saveFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        user.setAvatar(visitPath);

        int res = 0;
        try {
            res = userService.insertUser(user);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            // 注册成功
            return new CommonResult(200, "true");
        } else {
            // 用户名已存在
            return new CommonResult(401, "false");
        }
    }

    /**
     * 查询用户星球
     * @param account 账号
     * @return 返回用户登录的结果
     */
    @RequestMapping("/user/planet")
    public CommonResult<String> planet(@RequestParam("account") String account) {
        User user = userService.queryPlanet(account);
        if(user != null) {
            return new CommonResult(200, "true",user.getPlanet());
        } else {
            return new CommonResult(404, "false");
        }
    }

    /**
     * 获取用户信息
     * @param account 账号
     * @return 返回用户登录的结果
     */
    @RequestMapping("/user/userInfo")
    public CommonResult<String> userInfo(@RequestParam("account") String account) {
        User user = userService.queryuserInfo(account);
        if(user != null) {
            return new CommonResult(200, "true",user);
        } else {
            return new CommonResult(404, "false");
        }
    }

    /**
     * 更新用户信息(包括头像)
     * @param account
     * @param date
     * @param name
     * @param planet
     * @param file
     * @return
     */
    @RequestMapping("/user/updateUser")
    public CommonResult updateUser(@RequestParam("account") String account,@RequestParam("date") String date, @RequestParam("name") String name, @RequestParam("planet") String planet, @RequestParam("file") MultipartFile file) {
        // 获取当前时间并格式化设置随机地址
        String timeStamp = date;
        int data_1 = Integer.parseInt (String.valueOf(timeStamp.charAt(15)));
        char data_2 = timeStamp.charAt(17);
        char data_3 = timeStamp.charAt(18);
        if(Objects.equals(planet, "焦虑星")){
            address = "焦虑星" + addresslist1[data_1] + data_2 + data_3 +"号";
        } else if (Objects.equals(planet, "倦怠星")) {
            address = "倦怠星" + addresslist2[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "失落星")) {
            address = "失落星" + addresslist3[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "不开星")) {
            address = "不开星" + addresslist4[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "痛苦星")) {
            address = "痛苦星" + addresslist5[data_1] + data_2 + data_3 +"号";
        }

        //储存图片
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();
        String url_path = "images" + File.separator + fileName;
        String savePath = staticPath + File.separator + url_path;
        String visitPath="static/"+url_path;
        File saveFile = new File(savePath);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        try{
            file.transferTo(saveFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        int res = 0;
        try {
            res = userService.updateUser(account,name,planet,address,visitPath);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            // 注册成功
            return new CommonResult(200, "true");
        } else {
            // 用户名已存在
            return new CommonResult(401, "false");
        }
    }

    /**
     * 更新用户信息（不包括头像）
     * @param account
     * @param date
     * @param name
     * @param planet
     * @return
     */
    @RequestMapping("/user/updateUsers")
    public CommonResult updateUsers(@RequestParam("account") String account,@RequestParam("date") String date, @RequestParam("name") String name, @RequestParam("planet") String planet) {
        // 获取当前时间并格式化设置随机地址
        String timeStamp = date;
        int data_1 = Integer.parseInt (String.valueOf(timeStamp.charAt(15)));
        char data_2 = timeStamp.charAt(17);
        char data_3 = timeStamp.charAt(18);
        if(Objects.equals(planet, "焦虑星")){
            address = "焦虑星" + addresslist1[data_1] + data_2 + data_3 +"号";
        } else if (Objects.equals(planet, "倦怠星")) {
            address = "倦怠星" + addresslist2[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "失落星")) {
            address = "失落星" + addresslist3[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "不开星")) {
            address = "不开星" + addresslist4[data_1] + data_2 + data_3 +"号";
        }else if (Objects.equals(planet, "痛苦星")) {
            address = "痛苦星" + addresslist5[data_1] + data_2 + data_3 +"号";
        }

        int res = 0;
        try {
            res = userService.updateUsers(account,name,planet,address);
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
     * 查询是否签到
     * @param account
     * @return
     */
    @RequestMapping("/user/isClock")
    public CommonResult isClock(@RequestParam("account") String account) {
        User user = userService.isClock(account);
        if(user != null) {
            return new CommonResult(200, "true",user);
        } else {
            return new CommonResult(404, "false");
        }
    }

    /**
     * 改变签到状态增加签到数目
     * @param account
     * @return
     */
    @RequestMapping("/user/updateClock")
    public CommonResult updateClock(@RequestParam("account") String account) {
        int res = 0;
        try {
            res = userService.updateClock(account);
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
     * 更改最高分数
     * @param account
     * @param score
     * @return
     */
    @RequestMapping("/user/updateScore")
    public CommonResult updateScore(@RequestParam("account") String account, @RequestParam("score") int score) {
        int res = 0;
        try {
            res = userService.updateScore(account, score);
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
     * 查询最高分
     * @param account
     * @return
     */
    @RequestMapping("/user/queryScore")
    public CommonResult queryScore(@RequestParam("account") String account) {
        User res = userService.queryScore(account);
        if(res != null) {
            return new CommonResult(200, "true",res.getScore());
        } else {
            return new CommonResult(401, "false");
        }
    }

    /**
     * 查询最积分
     * @param account
     * @return
     */
    @RequestMapping("/user/getPoint")
    public CommonResult queryPoint(@RequestParam("account") String account) {
        User res = userService.queryPoint(account);
        if(res != null) {
            return new CommonResult(200, "true",res.getPoint());
        } else {
            return new CommonResult(401, "false");
        }
    }

    /**
     * 增加积分
     * @param account
     * @param point
     * @return
     */
    @RequestMapping("/user/addPoint")
    public CommonResult addPoint(@RequestParam("account") String account, @RequestParam("point") int point) {
        int res = 0;
        try {
            res = userService.addPoint(account, point);
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
     * 减少积分
     * @param account
     * @param point
     * @return
     */
    @RequestMapping("/user/subPoint")
    public CommonResult subPoint(@RequestParam("account") String account, @RequestParam("point") int point) {
        int res = 0;
        try {
            res = userService.subPoint(account, point);
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
