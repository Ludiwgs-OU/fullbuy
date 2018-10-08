package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /*new*/
    /*我的评论*/
    List<Comment> displayCommentByUserId(Integer userId);
    List<Comment> displayCommentBySalesId(Integer salesId);

    /*商品评论*/
    List<Comment> showProductComment(Integer productId);
}