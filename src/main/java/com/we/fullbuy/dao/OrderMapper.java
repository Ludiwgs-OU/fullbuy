package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /*new*/
    /*根据商家ID查找订单*/
    List<Order> selectBySalesId(Integer salesid);
    /*根据用户ID查找订单*/
    List<Order> selectByUserId(Integer userid);
    /*订单详情*/
    Order orderDetail(String orderid);
}