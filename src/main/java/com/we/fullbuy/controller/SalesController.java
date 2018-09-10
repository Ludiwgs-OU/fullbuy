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
    public int login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        Sales sales = salesService.login(phone);

        if (sales != null) {
            if (sales.getBlack()==0) {
                if (sales.getSalaespwd().equals(password))
                    return 1;//登录成功
                else
                    return 2;//密码错误
            }
            else
                return 3;//黑名单
        } else
            return 0;//账号不存在
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public int register()
    {
            Sales sales = new Sales();

        Sales check = salesService.login("1");
        if(check==null)
        {
            if(salesService.registerSales(sales)!=0)
                return 1;//注册成功
            else
                return 0;//注册失败
        }
        else
            return 2;//账号已存在
    }

    //查看个人信息
    @RequestMapping("/displayUserDetail")
    @ResponseBody
    public Sales displayUserDetail(@RequestParam("salesId") int salesId)
    {
        return salesService.displaySalesDetail(salesId);
    }

    //修改个人信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public int modifyUser(@RequestParam("salesId") int salesId)
    {
        Sales sales = new Sales();
        sales.setSalesid(salesId);

        return salesService.modifySales(sales);
    }
}
