package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Sales;
import com.we.fullbuy.service.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sales")
public class SalesController {
    @Resource
    private SalesService salesService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        Sales sales = salesService.login(phone);

        if (sales != null) {
            if (sales.getSalaespwd().equals(password))
                return "欢迎回来" + sales.getSalaesname();
            else
                return "密码错误，请重新输入密码";
        } else
            return "账号不存在，请检查";
    }
}
