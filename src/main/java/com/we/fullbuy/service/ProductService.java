package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Product;

import java.util.List;

public interface ProductService {
    /*添加商品*/
    int addProduct(Product product);
    /*修改商品*/
    int modifyProduct(Product product);
    /*删除商品*/
    int deleteProduct(int productId);
    /*商品列表*/
    List<Product> showProduct();
    /*商品详情*/
    Product showProductDetail(int productId);
    /*关键字搜索商品*/
    List<Product> searchProductByKeyword(String keyword);
    /*根据种类搜索商品*/
    List<Product> searchProductByCategory(int categoryId, int secondCategoryId);
}
