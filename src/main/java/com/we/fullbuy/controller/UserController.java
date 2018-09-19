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
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password,HttpSession session)
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
                    session.setAttribute("userId",user.getUserid());
                    return "登录成功，欢迎回来"+user.getUsername();//登录成功
                }

                else
                    return "密码好像输错了，再想想";//密码错误
            }
            else
                return "对不起，您处于我们的黑名单";//处于黑名单
        }
        else
            return "不存在的，你输入的账号不存在";//账号不存在
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user)
    {
        User check = userService.login(user.getUserphone());
        if(check==null)
        {
            if(userService.registerUser(user)!=0)
                return "注册成功~欢迎你加入满团大家庭";//注册成功
            else
                return "GG！注册失败了诶";//注册失败
        }
        else
            return "账号好像已经有别的用户使用了哦";//账号已存在
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
    public Boolean modifyUser(@RequestBody User user, HttpSession session)
    {
        user.setUserid((int)session.getAttribute("userId"));

        if (userService.modifyUser(user)!=0)
            return true;
        else
            return false;
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
    public boolean addAddress(@RequestBody Address address, HttpSession session)
    {
        address.setUserid((int)session.getAttribute("userId"));
        if(addressService.addAddress(address)!=0)
            return true;
        else
            return false;
    }

    //修改收货地址
    @RequestMapping("/modifyAddress")
    @ResponseBody
    public boolean modifyAddress(@RequestBody Address address)
    {
        if(addressService.modifyAddress(address)!=0)
            return true;
        else
            return false;
    }

    //删除收货地址
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public boolean deleteAddress(@RequestParam("addressId") int addressId)
    {
        if(addressService.deleteAddress(addressId)!=0)
            return true;
        else
            return false;
    }


    //查看收藏夹
    @RequestMapping("/displayFavor/{uid}")
    @ResponseBody
    public List<Favor> displayFavor(/*HttpSession session*/@PathVariable("uid") Integer userId)
    {
        /*return favorService.displayFavor((int)session.getAttribute("userId"));*/
        return favorService.displayFavor(userId);
    }

    //添加到收藏夹
    @RequestMapping("/addFavor")
    @ResponseBody
    public String addFavor(@RequestParam("productId") int productId, HttpSession session)
    {
        Favor favor = new Favor();
        favor.setUserid((int)session.getAttribute("userId"));
        favor.setProductid(productId);
        if(favorService.addFavor(favor)!=0)
            return "已帮您添加到收藏夹啦";
        else
            return "好像出了点问题，收藏不了商品";
    }

    //删除收藏夹单个商品
    @RequestMapping("/deleteSingleFavor")
    @ResponseBody
    public String deleteSingleFavor(@RequestParam("favorId") int favorId)
    {
        if(favorService.deleteSingleFavor(favorId)!=0)
            return "删除成功！商品已离去";
        else
            return "好像出了点问题，商品仍留在原地";
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
