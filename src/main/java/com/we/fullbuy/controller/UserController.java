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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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
                    Date date = new Date();
                    Timestamp timestamp = new Timestamp(date.getTime());
                    user.setLastLoginTime(timestamp);
                    userService.modifyUser(user);
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
        return userService.modifyUser(user);

    }

    //修改头像
    @RequestMapping("/modifyUserProfile")
    @ResponseBody
    public int modifyUserProfile(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException
    {
        User user = new User();
        user.setUserId((int)session.getAttribute("userId"));

        if (file != null) {
            //获取上传文件的原始名称
            String originalFilename = file.getOriginalFilename();
            // 上传图片
            if (originalFilename != null && originalFilename.length() > 0) {
                // 绝对路径
                String pic_path = "C:\\Users\\63249\\IdeaProjects\\fullbuy\\src\\main\\webapp\\UserProfile\\";
                // 新的图片名称
                String newName = session.getAttribute("userId") + Long.toString(System.currentTimeMillis());
                // 文件后缀
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 最终路径
                String finalPath = pic_path + newName + suffix;
                System.out.println("上传图片的路径：" + finalPath);
                // 新图片
                File newFile = new File(finalPath);
                // 检查文件夹是否存在 不存在就新建一个
                if (!newFile.isDirectory()) {
                    newFile.mkdirs();
                }
                // 将内存中的数据写入磁盘
                file.transferTo(newFile);

                user.setUserProfile("/UserProfile/" + newName + suffix);
            }
        }

        return userService.modifyUser(user);
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
