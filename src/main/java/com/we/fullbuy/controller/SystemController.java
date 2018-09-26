package com.we.fullbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/sys")
public class SystemController {
    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam ("type") int type, @RequestParam ("phone") String phone,
                        @RequestParam ("password") String password, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("phone", phone);
        redirectAttributes.addAttribute("password", password);
        if(type==1)
            return "redirect:/user/login";
        else
            return "redirect:/sales/login";
    }

    //注销
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate();
        if(session == null)
            return "注销成功";
        else
            return "注销失败";
    }

    //返回用户信息
    @RequestMapping("/navi")
    @ResponseBody
    public HashMap navi(HttpSession session){
        HashMap map = new HashMap();
        map.put("userName",session.getAttribute("userName"));
        map.put("userType",session.getAttribute("userType"));
        map.put("userProfile",session.getAttribute("userProfile"));
        return map;
    }
}
