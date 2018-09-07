package com.we.fullbuy.service;

import com.we.fullbuy.pojo.User;

public interface UserService {
    /*显示个人信息*/
    User displayUserDetail(int userId);
    /*修改个人信息*/
    int modifyUser(User user);
    /*注册*/
    int registerUser(User user);
    /*登录以及检查电话是否可用*/
    User login(String phone);
}
