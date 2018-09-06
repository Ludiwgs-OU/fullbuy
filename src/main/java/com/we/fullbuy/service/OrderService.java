package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Order;

import java.util.List;

public interface OrderService {
    /*生成订单*/
    int addOrder(int userId, int skuId);
    /*显示订单列表*/
    List<Order> showOrder(int id);
    /*订单详情*/
    Order showOrderDetail(int orderId);
    /*删除订单*/
    int deleteOrder(int orderId);
    /*取消订单*/
    int cancelOrder(int orderId);
    /*支付*/
    int Pay(int orderId);
    /*退款*/
    int refund(int orderId);


}
