package com.we.fullbuy.controller;

import com.we.fullbuy.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
}
