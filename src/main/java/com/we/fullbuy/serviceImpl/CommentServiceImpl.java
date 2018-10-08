package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.CommentMapper;
import com.we.fullbuy.pojo.Comment;
import com.we.fullbuy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteComment(int commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public List<Comment> searchComment(String keyword) {
        return null;
    }

    @Override
    public List<Comment> showProductComment(int productId) {
        return commentMapper.showProductComment(productId);
    }

    @Override
    public List<Comment> displayCommentByUserId(int userId) {
        return commentMapper.displayCommentByUserId(userId);
    }

    @Override
    public List<Comment> displayCommentBySalesId(int salesId) {
        return commentMapper.displayCommentBySalesId(salesId);
    }
}
