package com.we.fullbuy.service;

import com.we.fullbuy.pojo.News;

import java.util.List;

public interface NewsService {
   /* 添加公告*/
    int addNews(News news);
    /*删除公告*/
    int deleteNews(int newsId);
    /*修改公告*/
    int modifyNews(News news);
    /*公告列表*/
    List<News> showNews();
    /*公告详情*/
    News showNewsDetail(int newsId);
    /*根据关键字搜索公告*/
    List<News> searchByKeyword(String keyword);

}
