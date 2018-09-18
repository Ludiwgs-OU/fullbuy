package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    //商品SKU详情
    @RequestMapping("/displayProductDetailWithSku/{pid}")
    @ResponseBody
    public Product displayProductDetailWithSku(@PathVariable("pid") Integer productId){
        return productService.showProductDetail(productId);
    }

    //商品列表
    @RequestMapping("/displayProducts")
    @ResponseBody
    public List<Product> displayProducts()
    {
        return productService.showProduct();
    }

    //根据关键字搜索商品
    public List<Product> serachByKeyword(@RequestParam("keyword") String keyword)
    {
        return productService.searchProductByKeyword(keyword);
    }

    //根据一级种类显示商品
    public List<Product> serachByFirstCategory(@RequestParam("categoryId") int categoryId)
    {
        return productService.searchProductByFirstCategory(categoryId);
    }

    //根据二级种类显示商品
    public List<Product> serachBySecondCategory(@RequestParam("secondCategoryId") int secondCategoryId)
    {
        return productService.searchProductBySecondCategory(secondCategoryId);
    }


    //添加商品
    @RequestMapping("/addProduct")
    @ResponseBody
    public boolean addProduct(@RequestBody Product product)
    {
        if(productService.addProduct(product)!=0)
            return true;
        else
            return false;
    }

    //删除商品
    @RequestMapping("/deleteProduct")
    @ResponseBody
    public boolean deleteProduct(@RequestParam("productId") int productId)
    {
        if(productService.deleteProduct(productId)!=0)
            return true;
        else
            return false;
    }

    //更新商品
    @RequestMapping("/modifyProduct")
    @ResponseBody
    public boolean modifyProduct(@RequestBody Product product)
    {
        if(productService.modifyProduct(product)!=0)
            return true;
        else
            return false;
    }
}
