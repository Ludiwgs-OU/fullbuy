package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Manager;
import com.we.fullbuy.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;

    //管理员登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("managerId") String managerId, @RequestParam("password") String password)
    {

        //String cpassword = MD5Util.md5(password);
        System.out.println(managerId);
        System.out.println(password);
        int id = Integer.valueOf(managerId);
        Manager manager = managerService.login(id);
        if(manager.getManagerpwd().equals(password))
            return 1;
        else
            return 0;
    }

}
