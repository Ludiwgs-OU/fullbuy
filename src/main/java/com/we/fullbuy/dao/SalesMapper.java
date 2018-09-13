package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Sales;

public interface SalesMapper {
    int deleteByPrimaryKey(Integer salesid);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(Integer salesid);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

    /*new*/
    /*根据商家注册电话搜索*/
    Sales selectByPhone(String phone);
}