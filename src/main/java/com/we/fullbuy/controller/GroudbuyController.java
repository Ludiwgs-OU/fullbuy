package com.we.fullbuy.controller;


import com.we.fullbuy.pojo.Groudbuy;
import com.we.fullbuy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public int addGroudbuy(@RequestBody Groudbuy groudbuy, HttpSession session)
    {
        groudbuy.setSalesId((int)session.getAttribute("salesId"));
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
    public int modifyGroudbuy(@RequestBody Groudbuy groudbuy)
    {
        return groudbuyService.modifyGroudbuy(groudbuy);
    }

    //团购活动详情
    @RequestMapping("/displayGroudbuyDetail")
    @ResponseBody
    public Groudbuy displayGroudbuyDetail(@RequestParam("productId") int productId)
    {
        return groudbuyService.showGroudbuyDetail(productId);
    }

    //商家查询自己团购活动
    @RequestMapping("/displaySalesGroudbuy")
    @ResponseBody
    public List<Groudbuy> displaySalesGroudbuy(HttpSession session)
    {
        return groudbuyService.showGroudbuyBySalesId((int)session.getAttribute("salesId"));
    }

    //关键字查询团购活动
    @RequestMapping("/searchGroudbuy")
    @ResponseBody
    public List<Groudbuy> searchGroudbuy(String keyword)
    {
        return groudbuyService.searchGroudbuy(keyword);
    }
}
