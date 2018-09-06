package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Comment;

public interface CommentService {
    /*添加评论*/
    int addComment(Comment comment);
    /*删除评论*/
    int deleteComment(int commentId);
}
