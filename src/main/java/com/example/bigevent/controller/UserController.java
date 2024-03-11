package com.example.bigevent.controller;

import com.example.bigevent.pojo.PageBean;
import com.example.bigevent.pojo.Result;
import com.example.bigevent.pojo.User;
import com.example.bigevent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lh
 * @Date 2024/3/11 22:32
 */

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result register(String username, String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //注册
            userService.register(username,password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }

    }
}
