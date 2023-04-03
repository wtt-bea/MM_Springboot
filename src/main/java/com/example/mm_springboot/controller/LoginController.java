package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.User;
import com.example.mm_springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户登录
 */
@RestController
public class LoginController {
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
}
