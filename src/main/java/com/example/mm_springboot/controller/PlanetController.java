package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.User;
import com.example.mm_springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 星球查询
 */
@RestController
public class PlanetController {
    @Resource
    private UserService userService;

    /**
     * 用户登录的方法
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
}
