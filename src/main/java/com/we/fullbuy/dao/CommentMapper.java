package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /*new*/
    /*我的评论*/
    List<Comment> CommentWithOrder(Integer userid);
    /*商品评论*/
    List<Comment> showProductComment(Integer productid);
}