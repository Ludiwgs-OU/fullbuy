package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {

        //String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);

        User user = userService.login(phone);
        if(user!=null)
        {
            if(user.getPassword().equals(password))
                return 1;
            else
                return 2;
        }
        else
            return 0;
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public String register()
    {
        User user = new User();

        if(userService.registerUser(user)!=0)
            return "注册成功啦";
        else
            return "失败了诶，好像出了点问题";
    }
}
