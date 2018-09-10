package com.we.fullbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
