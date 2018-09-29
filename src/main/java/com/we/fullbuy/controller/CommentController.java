package com.we.fullbuy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fullbuy.pojo.Comment;
import com.we.fullbuy.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    //我的评论
    @RequestMapping("/displayCommentByUserId")
    @ResponseBody
    public List<Comment> displayCommentByUserId(HttpSession session)
    {
        return commentService.displayCommentByUserId((int) session.getAttribute("userId"));
    }

    //显示商品评论
    @RequestMapping("/showProductComment")
    @ResponseBody
    public PageInfo showProductComment(@RequestParam("productId") int productId,
                                       @RequestParam(value = "pageNo",defaultValue ="1") Integer pageNo){
        int pageSize = 5;
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo(commentService.showProductComment(productId));
    }


    //添加评论
    @RequestMapping("/addComment")
    @ResponseBody
    public String addComment(@RequestBody Comment comment, HttpSession session)
    {
        comment.setUserId((int)session.getAttribute("userId"));

        if(commentService.addComment(comment)!=0)
            return "评论成功";
        else
            return "好像出了点问题，评论失败";
    }
}
