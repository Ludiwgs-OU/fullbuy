package com.we.fullbuy.controller;


import com.we.fullbuy.pojo.Groudbuy;
import com.we.fullbuy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/groudbuy")
public class GroudbuyController {
    @Resource
    private GroudbuyService groudbuyService;

    //增加团购活动
    @RequestMapping("/addGroudbuy")
    @ResponseBody
    public int addGroudbuy(Groudbuy groudbuy)
    {
        return groudbuyService.addGroudbuy(groudbuy);
    }

    //删除团购活动
    @RequestMapping("/deleteGroudbuy")
    @ResponseBody
    public int deleteGroudbuy(@RequestParam("groudbuyId") int groudbuyId)
    {
        return groudbuyService.deleteGroudbuy(groudbuyId);
    }

    //修改团购活动
    @RequestMapping("/modifyGroudbuy")
    @ResponseBody
    public int modifyGroudbuy(@RequestParam("groudbuyId") int groudbuyId)
    {
        Groudbuy groudbuy = new Groudbuy();
        groudbuy.setGbid(groudbuyId);
        return groudbuyService.modifyGroudbuy(groudbuy);
    }

    //团购活动详情
    @RequestMapping("/displayGroudbuyDetail")
    @ResponseBody
    public Groudbuy displayGroudbuyDetail(@RequestParam("groudbuyId") int groudbuyId)
    {
        return groudbuyService.showGroudbuyDetail(groudbuyId);
    }

    //商家查询团购活动
    @RequestMapping("/displaySalesGroudbuy")
    @ResponseBody
    public List<Groudbuy> displaySalesGroudbuy(HttpSession session)
    {
        return groudbuyService.showGroudbuyBySalesId((int)session.getAttribute("salesId"));
    }

    //用户查询团购活动
    @RequestMapping("/displaySalesGroudbuy")
    @ResponseBody
    public List<Groudbuy> displayUserGroudbuy(HttpSession session)
    {
        return groudbuyService.showGroudbuyBySalesId((int)session.getAttribute("userId"));
    }

}
