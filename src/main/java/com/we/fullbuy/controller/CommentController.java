package com.we.fullbuy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fullbuy.pojo.Comment;
import com.we.fullbuy.pojo.Order;
import com.we.fullbuy.service.CommentService;
import com.we.fullbuy.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private OrderService orderService;

    //我的评论
    @RequestMapping("/displayCommentById")
    @ResponseBody
    public List<Comment> displayCommentById(HttpSession session)
    {
        if(session.getAttribute("userId") != null)
            return commentService.displayCommentByUserId((int) session.getAttribute("userId"));
        else if(session.getAttribute("salesId")!=null)
            return commentService.displayCommentBySalesId((int) session.getAttribute("salesId"));
        else
            return null;
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
    public int addComment(@RequestParam(value = "file",required = false) MultipartFile file,
                             @RequestParam("commentDetail") String commentDetail,
                             @RequestParam("productId") int productId,
                             @RequestParam("orderId") String orderId,
                             HttpSession session) throws IOException
    {

        Comment comment = new Comment();
        comment.setUserId((int) session.getAttribute("userId"));
        comment.setCommentDetail(commentDetail);
        comment.setOrderId(orderId);
        comment.setProductId(productId);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setCommentTime(timestamp);

        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(4);
        orderService.comment(order);

        if (file != null) {
            //获取上传文件的原始名称
            String originalFilename = file.getOriginalFilename();
            // 上传图片
            if (originalFilename != null && originalFilename.length() > 0) {
                // 绝对路径
                String pic_path = "C:\\Users\\63249\\IdeaProjects\\fullbuy\\src\\main\\webapp\\CommentPic\\";
                // 新的图片名称
                String newName = orderId + Long.toString(System.currentTimeMillis());
                // 文件后缀
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 最终路径
                String finalPath = pic_path + newName + suffix;
                System.out.println("上传图片的路径：" + finalPath);
                // 新图片
                File newFile = new File(finalPath);
                // 检查文件夹是否存在 不存在就新建一个
                if (!newFile.isDirectory()) {
                    newFile.mkdirs();
                }
                // 将内存中的数据写入磁盘
                file.transferTo(newFile);

                comment.setCommentImgPath("/CommentPic/" + newName + suffix);
            }
        }

        return commentService.addComment(comment);
    }
}
