package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Order;
import com.we.fullbuy.pojo.Sales;
import com.we.fullbuy.service.OrderService;
import com.we.fullbuy.service.SalesService;
import com.we.fullbuy.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    @Resource
    private SalesService salesService;
    @Resource
    private OrderService orderService;


    //登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpSession session) {

        String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);
        System.out.println(cpassword);

        Sales sales = salesService.login(phone);

        if (sales != null) {
            if (sales.getBlack()==0) {
                if (sales.getSalesPwd().equals(password))
                {
                    session.setAttribute("salesId",sales.getSalesId());
                    return 1;//登录成功
                }
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
    public int register(@RequestBody Sales sales)
    {
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

    //查看商家信息
    @RequestMapping("/displaySalesDetail")
    @ResponseBody
    public Sales displaySalesDetail(HttpSession session)
    {
        return salesService.displaySalesDetail((int)session.getAttribute("salesId"));
    }

    //修改商家信息
    @RequestMapping("/modifySales")
    @ResponseBody
    public int modifySales(@RequestBody Sales sales, HttpSession session)
    {
        sales.setSalesId((int)session.getAttribute("salesId"));

        return salesService.modifySales(sales);
    }

    //推荐商家
    @RequestMapping("/displayRecommend")
    @ResponseBody
    public List<Sales> displayRecommend()
    {
        return salesService.displayRecommend();
    }



    //确认收退款
    @RequestMapping("/confirmRefund")
    @ResponseBody
    public int confirmRefund(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(4);
        return orderService.confirm(order);
    }

    //发货
    @RequestMapping("/sendProduct")
    @ResponseBody
    public int sendProduct(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(2);
        return orderService.confirm(order);
    }

}
