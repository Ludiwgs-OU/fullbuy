package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Order;

import java.util.List;

public interface OrderService {
    /*生成订单*/
    int addOrder(Order order);
    /*显示订单列表*/
    List<Order> showOrder(int id);
    /*订单详情*/
    Order showOrderDetail(String orderId);
    /*删除订单*/
    int deleteOrder(String orderId);
    /*支付*/
    int Pay(Order order);
    /*退款*/
    int refund(Order order);
    /*确认收货*/
    int confirm(Order order);


}
