package com.we.fullbuy.controller;

import com.we.fullbuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
}
