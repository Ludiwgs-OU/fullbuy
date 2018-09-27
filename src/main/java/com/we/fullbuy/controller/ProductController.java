package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.pojo.Sku;
import com.we.fullbuy.service.ProductService;
import com.we.fullbuy.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private SkuService skuService;

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
    @RequestMapping("/serachByKeyword")
    @ResponseBody
    public List<Product> serachByKeyword(@RequestParam("keyword") String keyword, HttpSession session)
    {
        session.setAttribute("keyword",keyword);
        return productService.searchProductByKeyword(keyword);
    }


    //根据一级种类显示商品
    @RequestMapping("/serachByFirstCategory")
    @ResponseBody
    public List<Product> serachByFirstCategory(@RequestParam("categoryId") int categoryId)
    {
        return productService.searchProductByFirstCategory(categoryId);
    }


    //根据二级种类显示商品
    @RequestMapping("/serachBySecondCategory")
    @ResponseBody
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

    //获取价格
    @RequestMapping("/getPrice")
    @ResponseBody
    public HashMap getPrice(@RequestParam("productId") int productId,
                            @RequestParam("itemId") int itemId,
                            @RequestParam("secondItemId") int secondItemId,
                            @RequestParam("type") int type)
    {
        Sku sku = skuService.getPrice(productId,itemId,secondItemId);
        HashMap map = new HashMap();
        if(type==0)
            map.put("price",sku.getPrice());
        else
            map.put("price",sku.getGbprice());
        map.put("quantity",sku.getQuantity());
        map.put("skuId",sku.getSkuid());

        return map;
    }

    //按销售量推荐
    @RequestMapping("/displayBySalesnum")
    @ResponseBody
    public List<Product> displayBySalesnum()
    {
        return productService.displayBySalesnum();
    }

    //按评分推荐
    @RequestMapping("/displayByScore")
    @ResponseBody
    public List<Product> displayByScore()
    {
        return productService.displayByScore();
    }

    //按上传的时间推荐商品
    @RequestMapping("/displayByPosttime")
    @ResponseBody
    public List<Product> displayByPosttime()
    {
        return productService.displayByPosttime();
    }

    //详情图片
    @RequestMapping("/detailImgPth")
    @ResponseBody
    public HashMap detailImgPth(@RequestParam("productId") int productId)
    {
        Product product =  productService.detailImgPth(productId);
        HashMap map = new HashMap();
        map.put("DetailImgPath1",product.getDetailimgpath1());
        map.put("DetailImgPath2",product.getDetailimgpath2());
        return map;
    }

    //相关推荐商品
    @RequestMapping("/relatedProduct")
    @ResponseBody
    public List<Product> relatedProduct(@RequestParam("productId") int productId)
    {
        return productService.relatedProduct(productId);
    }
}
