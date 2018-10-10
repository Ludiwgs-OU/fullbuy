package com.we.fullbuy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fullbuy.pojo.*;
import com.we.fullbuy.service.CategoryService;
import com.we.fullbuy.service.ItemService;
import com.we.fullbuy.service.ProductService;
import com.we.fullbuy.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private SkuService skuService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private ItemService itemService;


    //商品SKU详情
    @RequestMapping("/displayProductDetailWithSku")
    @ResponseBody
    public Product displayProductDetailWithSku(@RequestParam("productId") int productId){
        Product product = productService.showProductDetail(productId);
        System.out.println(product.getCategoryId());
        Category category = categoryService.searchBycategoryId(product.getCategoryId());
        Secondcategory secondcategory = categoryService.searchBysecondCategoryId(product.getSecondCategoryId());
        product.setCategoryName(category.getCategoryName());
        product.setSecondCategoryName(secondcategory.getSecondCategoryName());

        return  product;
    }



    //商品列表
    @RequestMapping("/displayProducts")
    @ResponseBody
    public List<Product> displayProducts()
    {
        return productService.showProduct();
    }

    //显示商家商品
    @RequestMapping("/displaySalesProducts")
    @ResponseBody
    public List<Product> displaySalesProducts(@RequestParam("salesId") int salesId){

        return productService.displaySalesProducts(salesId);
    }


    //根据关键字搜索商品
    @RequestMapping("/serachByKeyword")
    @ResponseBody
    public PageInfo serachByKeyword(@RequestParam("keyword") String keyword, @RequestParam(value = "pageNo",defaultValue ="1") Integer pageNo){
        int pageSize = 8;
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo(productService.searchProductByKeyword(keyword));
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
    public int addProduct(@RequestBody Product product,
                             @RequestParam(value = "files",required = false) MultipartFile[] files,
                             @RequestParam("itemList") List<Item> itemList,
                             @RequestParam("secondItemList") List<Seconditem> secondItemList,
                             HttpSession session) throws IOException {

        if (productService.addProduct(product) != 0) {

            // 上传图片
            if (files != null && files.length > 0) {
                //循环获取file数组中得文件
                for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    //获取上传文件的原始名称
                    String originalFilename = file.getOriginalFilename();
                    if (originalFilename.endsWith("jpg") || originalFilename.endsWith("png") || originalFilename.endsWith("jpeg")) {
                        // 绝对路径
                        System.out.println(session.getAttribute("salesId"));
                        System.out.println(product.getProductId());
                        String pic_path = "C:\\Users\\63249\\IdeaProjects\\fullbuy\\src\\main\\webapp\\ProductPic" + session.getAttribute("salesId") + "\\"
                                + product.getProductId() + "\\";
                        // 新的图片名称
                        String newName = product.getProductId() + Long.toString(System.currentTimeMillis());
                        // 文件后缀
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                        // 最终路径
                        String finalPath = pic_path + newName + suffix;
                        System.out.println("上传图片的路径：" + finalPath);
                        // 新图片
                        File newFile = new File(finalPath);
                        // 检查文件夹是否存在 不存在就新建一个
                        if (!newFile.isDirectory()) {
                            newFile.mkdirs();
                        }
                        try {
                            // 将内存中的数据写入磁盘
                            file.transferTo(newFile);
                            String sqlPath = "/ProductPic/" + newName + suffix;
                            if(i==0)
                                product.setSearchImgPath(sqlPath);
                            else if(i==1)
                                product.setbImgPath1(sqlPath);
                            else if(i==2)
                                product.setbImgPath2(sqlPath);
                            else if(i==3)
                                product.setDetailImgPath1(sqlPath);
                            else
                                product.setDetailImgPath2(sqlPath);
                            productService.modifyProduct(product);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }


            //添加规格

            for(int i = 0;i < itemList.size(); i++)
            {
                if(itemService.addItem(itemList.get(i))==0)
                {
                    System.out.println("additem failed");
                    break;
                }
            }

            for(int j = 0;j < secondItemList.size(); j++)
            {
                if(itemService.addSecondItem(secondItemList.get(j))==0)
                {
                    System.out.println("addseconditem failed");
                    break;
                }
            }


        }
        return product.getProductId();
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
    public boolean modifyProduct(@RequestBody Product product,
                              @RequestParam(value = "searchImgPath",required = false) MultipartFile[] searchImg,
                              @RequestParam(value = "bImg1Path",required = false) MultipartFile[] bImg1,
                              @RequestParam(value = "bImg2Path",required = false) MultipartFile[] bImg2,
                              @RequestParam(value = "detailImgPath1",required = false) MultipartFile[] detailImg1,
                              @RequestParam(value = "detailImgPath2",required = false) MultipartFile[] detailImg2)
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
            map.put("price",sku.getGbPrice());
        map.put("quantity",sku.getQuantity());
        map.put("skuId",sku.getSkuId());

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
        map.put("DetailImgPath1",product.getDetailImgPath1());
        map.put("DetailImgPath2",product.getDetailImgPath2());
        return map;
    }

    //相关推荐商品
    @RequestMapping("/relatedProduct")
    @ResponseBody
    public List<Product> relatedProduct(@RequestParam("productId") int productId)
    {
        return productService.relatedProduct(productId);
    }

    //获取商品SKU
    @RequestMapping("/displaySku")
    @ResponseBody
    public List<Sku> displaySku(@RequestParam("productId") int productId)
    {
        return skuService.displaySku(productId);
    }

    //获取一级分类
    @RequestMapping("/displayCategory")
    @ResponseBody
    public List<Category> displayCategory()
    {
        return categoryService.displayCategory();
    }

    //获取二级分类
    @RequestMapping("/displaySecondCategory")
    @ResponseBody
    public List<Secondcategory> displaySecondCategory(@RequestParam("categoryId") int categoryId)
    {
        return categoryService.displaySecondCategory(categoryId);
    }

    //规格
    @RequestMapping("/displayItems")
    @ResponseBody
    public HashMap displayItems() {
        HashMap map = new HashMap();
        List<Item> itemList = itemService.displayItem();
        List<Seconditem> secondItemList = itemService.displaySecondItem();
        map.put("itemList",itemList);
        map.put("secondItemList",secondItemList);
        return map;
    }

    //添加Sku
    @RequestMapping("/addSku")
    @ResponseBody
    public int addSku(@RequestParam("SkuList") List<Sku> SkuList)
    {
        int flag = 1;
        for(int i=0;i<SkuList.size();i++)
        {
            if(skuService.addSku(SkuList.get(i))==0)
            {
                flag = 0;
                break;
            }
        }

        return flag;
    }
}
