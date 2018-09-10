package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {

        //String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);

        User user = userService.login(phone);
        if(user!=null)
        {
            if(user.getBlack()==0)
            {
                if(user.getPassword().equals(password))
                    return 1;//登录成功
                else
                    return 2;//密码错误
            }
            else
                return 3;//处于黑名单
        }
        else
            return 0;//账号不存在
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public int register()
    {
        User user = new User();

        User check = userService.login("1");
        if(check==null)
        {
            if(userService.registerUser(user)!=0)
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
    public User displayUserDetail(@RequestParam("userId") int userId)
    {
        return userService.displayUserDetail(userId);
    }

    //修改个人信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public int modifyUser(@RequestParam("userId") int userId)
    {
        User user = new User();
        user.setUserid(userId);

       return userService.modifyUser(user);
    }

    //注销
    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
