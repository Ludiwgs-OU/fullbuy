package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    //商品详情
    @RequestMapping("/displayProductDetailWithSku/{pid}")
    @ResponseBody
    public Product displayProductDetailWithSku(@PathVariable("pid") Integer productId){
        return productService.showProductDetail(productId);
    }

}
