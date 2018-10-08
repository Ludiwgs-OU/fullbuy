package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Sales;
import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.SalesService;
import com.we.fullbuy.service.UserService;
import com.we.fullbuy.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/sys")
public class SystemController {
    @Resource
    private UserService userService;
    @Resource
    private SalesService salesService;

    //登录
    @RequestMapping("/login")
    public String login(@RequestParam ("type") int type, @RequestParam ("phone") String phone,
                        @RequestParam ("password") String password, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("phone", phone);
        redirectAttributes.addAttribute("password", password);
        System.out.println(password);
        System.out.println(phone);
        if(type==1)
            return "redirect:/user/login";
        else
            return "redirect:/sales/login";
    }

    //注销
    @RequestMapping("/logout")
    @ResponseBody
    public int logout(HttpSession session) {
        session.invalidate();
        return 1;
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

    //修改密码
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public int modifyPassword(@RequestParam("oldPassword") String oldPassword,
                              @RequestParam("newPassword") String newPassword,
                              HttpSession session)
    {
        if(session.getAttribute("userId") != null)
        {
            User user = userService.displayUserDetail((int)session.getAttribute("userId"));
            String cpassword = MD5Util.md5(oldPassword);
            if(user.getPassword().equals(cpassword))
            {
                user.setPassword(MD5Util.md5(newPassword));
                if (userService.modifyUser(user)!=0)
                    return 1;/*"修改密码成功，记得保存好哦";*/
                else
                    return 0;/*"修改密码失败";*/
            }
            else
                return 2;/*"旧密码错误哦";*/
        }
        else
        {
            Sales sales = salesService.displaySalesDetail((int)session.getAttribute("salesId"));
            String cpassword = MD5Util.md5(oldPassword);
            if(sales.getSalesPwd().equals(cpassword))
            {
                sales.setSalesPwd(MD5Util.md5(newPassword));
                if (salesService.modifySales(sales)!=0)
                    return 1;/*"修改密码成功，记得保存好哦";*/
                else
                    return 0;/*"修改密码失败";*/
            }
            else
                return 2;/*"旧密码错误哦";*/
        }


    }
}
