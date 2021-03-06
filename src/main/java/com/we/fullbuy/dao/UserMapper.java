package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*new*/
    /*根据用户注册电话搜索*/
    User selectByPhone(String phone);
}