package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Sales;

public interface SalesService {
    /*显示商家信息*/
    Sales displaySalesDetail(int salesId);
    /*修改商家信息*/
    int modifySales(Sales sales);
    /*注册*/
    int registerSales(Sales sales);
    /*登录*/
    Sales login(String phone);
}
