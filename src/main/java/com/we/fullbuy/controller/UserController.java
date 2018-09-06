package com.we.fullbuy.controller;

import com.we.fullbuy.service.SalesService;
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
    @Resource
    private SalesService salesService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam("phone") String phone, @RequestParam("password") String password, @RequestParam("type") int type)
    {

        //String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);
        if(type==1)
        {
            User user = userService.login(phone);
            if(user.getLoginpwd().equals(password))
                return true;
            else
                return false;
        }
        else
        {
            Sales sales = salesService.login(phone);
            if(sales.getSalaespwd().equals(password))
                return true;
            else
                return false;
        }

    }
}
