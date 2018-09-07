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
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {

        //String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);

        User user = userService.login(phone);
        if(user!=null)
        {
            if(user.getPassword().equals(password))
                return "欢迎回来"+user.getUsername();
            else
                return "密码错误，请重新输入密码";
        }
        else
            return "账号不存在，请检查";
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
