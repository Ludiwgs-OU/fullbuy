package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Product;
import org.springframework.web.bind.annotation.RequestParam;

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
    /*显示商家商品*/
    List<Product> displaySalesProducts(int salesId);
    /*商品详情*/
    Product showProductDetail(int productId);
    /*关键字搜索商品*/
    List<Product> searchProductByKeyword(String keyword);
    /*根据一级种类搜索商品*/
    List<Product> searchProductByFirstCategory(int categoryId);
    /*二级种类搜索商品*/
    List<Product> searchProductBySecondCategory(int secondCategoryId);
    /*根据skuID查商品信息*/
    Product searchBySkuId(int skuId);
    /*根据销量显示商品*/
    List<Product> displayBySalesnum();
    /*根据评分显示商品*/
    List<Product> displayByScore();
    /*根据上传时间显示商品*/
    List<Product> displayByPosttime();
    /*详情图片*/
    Product detailImgPth(int productId);
    /*相关商品推荐*/
    List<Product> relatedProduct(int productId);

}
