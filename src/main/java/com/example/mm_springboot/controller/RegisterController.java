package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.User;
import com.example.mm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Arrays.asList;

@RestController
public class RegisterController {
    @Autowired
    public UserService userService;

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
    @GetMapping("/user/register")
    public CommonResult doRegister(@RequestParam("account") String account,  @RequestParam("password") String password, @RequestParam("name") String name,@RequestParam("planet") String planet) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setPlanet(planet);
        // 获取当前时间并格式化获取系统时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Calendar now = Calendar.getInstance();
        String currentTime = sf.format(now.getTime());
        user.setAge(currentTime);

        // 获取当前时间并格式化设置随机地址
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp = simpleDateFormat.format(new Date());
        int data_1 = Integer.parseInt (String.valueOf(timeStamp.charAt(14)));
        char data_2 = timeStamp.charAt(15);
        char data_3 = timeStamp.charAt(16);
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

        int res = 0;
        try {
            res = userService.insertUser(user);
        } catch (Exception e) {
        }
        if(res == 1) {
            // 注册成功
            return new CommonResult(200, "true");
        } else {
            // 用户名已存在
            return new CommonResult(401, "false");
        }
    }
    //保存验证码和时间
}
