package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Address;
import com.we.fullbuy.pojo.Favor;
import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.AddressService;
import com.we.fullbuy.service.FavorService;
import com.we.fullbuy.service.UserService;
import com.we.fullbuy.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//用户
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AddressService addressService;
    @Resource
    private FavorService favorService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("phone") String phone, @RequestParam("password") String password,HttpSession session)
    {

        String cpassword = MD5Util.md5(password);
        System.out.println(phone);
        System.out.println(password);
        System.out.println(cpassword);

        User user = userService.login(phone);
        if(user!=null)
        {
            if(user.getBlack()==0)
            {
                if(user.getPassword().equals(cpassword))
                {
                    session.setAttribute("userId",user.getUserId());
                    session.setAttribute("userName",user.getUserName());
                    String userType;
                    if(user.getUserType()==1)
                        userType="高级会员";
                    else
                        userType="普通会员";
                    session.setAttribute("userType",userType);
                    session.setAttribute("userProfile",user.getUserProfile());
                    return 1;//登录成功
                }

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
    public int register(@RequestBody User user)
    {
        User check = userService.login(user.getUserPhone());
        if(check==null)
        {
            if(userService.registerUser(user)!=0)
                return 1;/*"注册成功~欢迎你加入满团大家庭";*///注册成功
            else
                return 0;/*"GG！注册失败了诶";*///注册失败
        }
        else
            return 2;/*"账号好像已经有别的用户使用了哦";*///账号已存在
    }

    //查看个人信息
    @RequestMapping("/displayUserDetail")
    @ResponseBody
    public User displayUserDetail(HttpSession session)
    {
        return userService.displayUserDetail((int)session.getAttribute("userId"));
    }

    //修改个人信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public int modifyUser(@RequestBody User user, HttpSession session)
    {
        user.setUserId((int)session.getAttribute("userId"));
        System.out.println(user.getSex());
        return userService.modifyUser(user);

    }

    //修改头像
    @RequestMapping("/modifyUserProfile")
    @ResponseBody
    public int modifyUserProfile(@RequestParam("userProfile") String userProfile, HttpSession session)
    {
        User user = new User();
        user.setUserId((int)session.getAttribute("userId"));
        user.setUserProfile(userProfile);
        return userService.modifyUser(user);

    }

    //修改密码
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public int modifyPassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpSession session)
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

    //显示用户收货地址
    @RequestMapping("/displayAddress")
    @ResponseBody
    public List<Address> displayAddress(HttpSession session)
    {
        return addressService.displayAddress((int)session.getAttribute("userId"));
    }

    //显示收货地址详情
    @RequestMapping("/displayAddressDetail")
    @ResponseBody
    public Address displayAddressDetail(@RequestParam("addressId") int addressId)
    {
        return addressService.displayAddressDetail(addressId);
    }


    //添加收货地址
    @RequestMapping("/addAddress")
    @ResponseBody
    public int addAddress(@RequestBody Address address, HttpSession session)
    {
        address.setUserId((int)session.getAttribute("userId"));
        return addressService.addAddress(address);
            /*return 1;*//*添加收货地址成功*//*
        else
            return 0;*//*添加收货地址失败*/
    }

    //修改收货地址
    @RequestMapping("/modifyAddress")
    @ResponseBody
    public int modifyAddress(@RequestBody Address address)
    {
        return addressService.modifyAddress(address);
          /*  return "修改收货地址成功";
        else
            return "修改收货地址失败";*/
    }

    //删除收货地址
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public int deleteAddress(@RequestParam("addressId") int addressId)
    {
        return addressService.deleteAddress(addressId);
            /*return 1;*//*"删除收货地址成功"*//*
        else
            return 0;*//*"删除收货地址成功"*/
    }


    //查看收藏夹
    @RequestMapping("/displayFavor")
    @ResponseBody
    public List<Favor> displayFavor(HttpSession session)
    {
        return favorService.displayFavor((int)session.getAttribute("userId"));

    }

    //添加到收藏夹
    @RequestMapping("/addFavor")
    @ResponseBody
    public int addFavor(@RequestParam("productId") int productId, HttpSession session)
    {
        Favor favor = new Favor();
        favor.setUserId((int)session.getAttribute("userId"));
        favor.setProductId(productId);
        return favorService.addFavor(favor);
           /* return 1;*//*"已帮您添加到收藏夹啦"*//*
        else
            return 0;*//*"好像出了点问题，收藏不了商品"*/
    }

    //删除收藏夹单个商品
    @RequestMapping("/deleteSingleFavor")
    @ResponseBody
    public int deleteSingleFavor(@RequestParam("favorId") int favorId)
    {
        return favorService.deleteSingleFavor(favorId);
           /* return 1;*//*"删除成功！商品已离去"*//*
        else
            return 0;*//*"好像出了点问题，商品仍留在原地"*/
    }

    /*//批量删除收藏夹商品
    @RequestMapping("/deleteFavor")
    @ResponseBody
    public boolean deleteFavor(@RequestParam("favorId") List<Integer> favorId)
    {
        if(favorService.deleteFavors(favorId)!=0)
            return true;
        else
            return false;
    }*/


}
