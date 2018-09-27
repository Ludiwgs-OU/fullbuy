package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Comment;

import java.util.List;

public interface CommentService {
    /*添加评论*/
    int addComment(Comment comment);
    /*删除评论*/
    int deleteComment(int commentId);
    /*搜索评论*/
    List<Comment> searchComment(String keyword);
    /*查看商品评论*/
    List<Comment> showProductComment(int productId);
    /*我的评论*/
    List<Comment> CommentWithOrder(int userId);
}
