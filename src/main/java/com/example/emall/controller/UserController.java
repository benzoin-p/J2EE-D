package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@Api(tags = "用户控制器")
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param uid      uid
     * @param userName 用户名
     * @param password 密码
     * @return {@link Result}
     */
    @PostMapping(value = "register")
    public Result register(@RequestParam String uid,
                           @RequestParam String userName,
                           @RequestParam String password)
    {
        return userService.register(uid,userName,password);
    }

    /**
     * 登录
     *
     * @param uid      uid
     * @param password 密码
     * @return {@link Result}
     */
    @GetMapping(value = "login")
    public Result login(@RequestParam String uid,
                        @RequestParam String password)
    {
        return userService.login(uid,password);
    }

    /**
     * 改变名字
     *
     * @param uid     uid
     * @param newName 新名字
     * @return {@link Result}
     */
    @PostMapping(value = "changeName")
    public Result changeName(@RequestParam String uid,
                             @RequestParam String newName)
    {
        return userService.changeName(uid,newName);
    }

    /**
     * 确认旧密码
     *
     * @param uid      uid
     * @param password 密码
     * @return {@link Result}
     */
    @GetMapping(value = "confirmOldPassword")
    public Result confirmOldPassword(@RequestParam String uid,
                                     @RequestParam String password)
    {
        return userService.confirmOldPassword(uid,password);
    }

    /**
     * 更改密码
     *
     * @param uid         uid
     * @param newPassword 新密码
     * @return {@link Result}
     */
    @PostMapping(value = "changePassword")
    public Result changePassword(@RequestParam String uid,
                                 @RequestParam String newPassword)
    {
        return userService.changePassword(uid,newPassword);
    }

}
