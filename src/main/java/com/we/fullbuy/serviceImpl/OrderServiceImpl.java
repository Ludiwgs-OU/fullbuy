package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.OrderMapper;
import com.we.fullbuy.pojo.Order;
import com.we.fullbuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public int addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order showOrderDetail(String orderId) {
        return orderMapper.orderDetail(orderId);
    }

    @Override
    @Transactional
    public int deleteOrder(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    @Transactional
    public int Pay(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int refund(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int confirm(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<Order> showSalesOrder(int salesId) {
        return orderMapper.selectBySalesId(salesId);
    }

    @Override
    public List<Order> showUserOrder(int userId) {
        return orderMapper.selectByUserId(userId);
    }
}
