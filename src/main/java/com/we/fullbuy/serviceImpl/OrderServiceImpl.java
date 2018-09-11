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
    @Transactional
    public List<Order> showOrder(int id) {
        return null;
    }

    @Override
    @Transactional
    public Order showOrderDetail(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
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
}
