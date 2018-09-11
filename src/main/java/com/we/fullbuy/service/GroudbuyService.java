package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Groudbuy;

import java.util.List;

public interface GroudbuyService {
    /*添加团购活动*/
    int addGroudbuy(Groudbuy groudbuy);
    /*修改团购活动*/
    int modifyGroudbuy(Groudbuy groudbuy);
    /*商家查看自己的团购活动*/
    List<Groudbuy> showGroudbuyBySalesId(int salesId);
    /*查看团购活动*/
    List<Groudbuy> showAllGroudbuy();
    /*搜索团购活动*/
    List<Groudbuy> searchGroudbuy(String keyword);
    /*删除团购活动*/
    int deleteGroudbuy(int groudbuyId);
    /*团购活动详情*/
    Groudbuy showGroudbuyDetail(int groudbuyId);
}
