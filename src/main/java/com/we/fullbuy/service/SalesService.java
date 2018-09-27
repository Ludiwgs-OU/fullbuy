package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Sales;

import java.util.List;

public interface SalesService {
    /*显示商家信息*/
    Sales displaySalesDetail(int salesId);
    /*修改商家信息*/
    int modifySales(Sales sales);
    /*注册*/
    int registerSales(Sales sales);
    /*登录*/
    Sales login(String phone);
    /*推荐商家*/
    List<Sales> displayRecommend();
}
