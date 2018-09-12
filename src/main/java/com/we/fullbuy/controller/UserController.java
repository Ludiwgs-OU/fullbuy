package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Address;
import com.we.fullbuy.pojo.Favor;
import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.AddressService;
import com.we.fullbuy.service.FavorService;
import com.we.fullbuy.service.UserService;
import com.we.fullbuy.utils.MD5Util;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                    session.setAttribute("userId",user.getUserid());
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
    public User displayUserDetail(HttpSession session)
    {
        return userService.displayUserDetail((int)session.getAttribute("userId"));
    }

    //修改个人信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public Boolean modifyUser(HttpSession session)
    {
        User user = new User();
        user.setUserid((int)session.getAttribute("userId"));

        if (userService.modifyUser(user)!=0)
            return true;
        else
            return false;
    }

    //显示收货地址
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
    public boolean addAddress(HttpSession session)
    {
        Address address = new Address();
        address.setUserid((int)session.getAttribute("userId"));
        if(addressService.addAddress(address)!=0)
            return true;
        else
            return false;
    }

    //修改收货地址
    @RequestMapping("/modifyAddress")
    @ResponseBody
    public boolean modifyAddress(@RequestParam("addressId") int addressId)
    {
        Address address = new Address();
        address.setAddressid(addressId);
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
    @RequestMapping("/displayFavor")
    @ResponseBody
    public List<Favor> displayFavor(HttpSession session)
    {
        return favorService.displayFavor((int)session.getAttribute("userId"));
    }

    //添加到收藏夹
    @RequestMapping("/addFavor")
    @ResponseBody
    public boolean addFavor(@RequestParam("productId") int productId, HttpSession session)
    {
        Favor favor = new Favor();
        favor.setUserid((int)session.getAttribute("userId"));
        favor.setProductid(productId);
        if(favorService.addFavor(favor)!=0)
            return true;
        else
            return false;
    }

    //删除收藏夹单个商品
    @RequestMapping("/deleteSingleFavor")
    @ResponseBody
    public boolean deleteSingleFavor(@RequestParam("favorId") int favorId)
    {
        if(favorService.deleteSingleFavor(favorId)!=0)
            return true;
        else
            return false;
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
