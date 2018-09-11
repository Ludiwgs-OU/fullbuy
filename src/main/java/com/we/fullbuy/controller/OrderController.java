package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.*;
import com.we.fullbuy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private SkuService skuService;
    @Resource
    private AddressService addressService;
    @Resource
    private ProductService productService;
    @Resource
    private UserService userService;
    @Resource
    private GroudbuyService groudbuyService;

    //生成普通订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public int addOrder(@RequestParam("skuId") int skuId, @RequestParam("num") int num, HttpSession session) {

        //获取订单编号
        int userId = (int) session.getAttribute("userId");
        String cdate = Long.toString(System.currentTimeMillis());
        String orderId = userId + cdate;
        System.out.println("订单编号：" + orderId);

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());//时间格式转换

        Sku sku = skuService.showSku(skuId);
        if(num<sku.getQuantity())//库存量比较
        {
            Order order = new Order();
            order.setOrderid(orderId);
            order.setOrderdate(timestamp);
            order.setOrderstatus(0);
            order.setNum(num);
            order.setUserid(userId);
            order.setPostfee(6);
            order.setTotalprice(sku.getPrice() * num + order.getPostfee());
            Address address = addressService.searchDefaultAddress();
            order.setAddressid(address.getAddressid());
            order.setSkuid(skuId);
            if(orderService.addOrder(order)==1)
            {
                sku.setQuantity(sku.getQuantity()-num);
                int s = skuService.updateSku(sku);
                if(s!=0)
                    System.out.println("sku Success");//减库存量

                Product product = new Product();
                product.setProductid(sku.getProductid());
                product.setSalesnum(product.getSalesnum()+num);//增加销售量
                int p = productService.modifyProduct(product);
                if(p!=0)
                    System.out.println("pro success");

                return 1;//订单生成成功
            }
            else
                return 2;//订单生成失败
        }
        else
            return 0;//库存量不足
    }

    //生成团购订单
    @RequestMapping("/addGroudbuyOrder")
    @ResponseBody
    public int addGroudbuyOrder(@RequestParam("skuId") int skuId, @RequestParam("groudbuyId") int groudbuyId, HttpSession session) {
        //获取订单编号
        int userId = (int) session.getAttribute("userId");
        String cdate = Long.toString(System.currentTimeMillis());
        String orderId = userId + cdate;
        System.out.println("订单编号：" + orderId);

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());//时间格式转换

        Sku sku = skuService.showSku(skuId);

        Order order = new Order();
        order.setOrderid(orderId);
        order.setOrderdate(timestamp);
        order.setOrderstatus(0);
        order.setUserid(userId);
        order.setPostfee(6);
        order.setTotalprice(sku.getGbprice() + order.getPostfee());
        Address address = addressService.searchDefaultAddress();
        order.setAddressid(address.getAddressid());
        order.setSkuid(skuId);
        if(orderService.addOrder(order)==1)
        {
            sku.setQuantity(sku.getQuantity());
            Product product = new Product();
            product.setProductid(sku.getProductid());
            product.setSalesnum(product.getSalesnum()+1);//增加销售量
            int p = productService.modifyProduct(product);
            if(p!=0)
                System.out.println("pro success");
            Groudbuy groudbuy = new Groudbuy();
            groudbuy.setNowpeople(groudbuy.getNowpeople()+1);
            groudbuy.setGbid(groudbuyId);
            if(groudbuyService.modifyGroudbuy(groudbuy)!=0)
                System.out.println("团购人数+1");

            return 1;//订单生成成功
        }
        else
            return 2;//订单生成失败
    }

    //显示商家订单列表
    @RequestMapping("/displaySalesOrder")
    @ResponseBody
    public List<Order> displaySalesOrder(HttpSession session){
        return orderService.showSalesOrder((int)session.getAttribute("salesId"));
    }

    //显示商家订单列表
    @RequestMapping("/displayUserOrder")
    @ResponseBody
    public List<Order> displayUserOrder(HttpSession session){
        return orderService.showSalesOrder((int)session.getAttribute("userId"));
    }

    //订单详情
    @RequestMapping("/displayOrderDetail")
    @ResponseBody
    public Order displayOrderDetail(@RequestParam("orderId") String orderId)
    {
        return orderService.showOrderDetail(orderId);
    }

    //删除订单
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public boolean deleteOrder(@RequestParam("orderId") String orderId)
    {
        if(orderService.deleteOrder(orderId)!=0)
            return true;
        else
            return false;
    }


    //支付
    @RequestMapping("/pay")
    @ResponseBody
    public boolean pay(@RequestParam("orderId") String orderId, HttpSession session)
    {
        Order order = orderService.showOrderDetail(orderId);
        order.setOrderstatus(1);
        if(orderService.Pay(order)!=0)
        {
            System.out.println("订单已支付");
            User user = new User();
            user.setUserid((int)session.getAttribute("userId"));
            user.setUserscore(user.getUserscore()+(int)(order.getTotalprice()*0.1));
            if(userService.modifyUser(user)!=0)
                System.out.println("积分已增加");
            return true;
        }
        else
        {
            System.out.println("订单支付失败");
            return false;
        }
    }

    //确认收货
    @RequestMapping("/confirm")
    @ResponseBody
    public boolean confirm(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderid(orderId);
        order.setOrderstatus(3);
        if(orderService.confirm(order)!=0)
        {
            System.out.println("订单已收货");
            return true;
        }
        else
        {
            System.out.println("订单收货失败");
            return false;
        }
    }

    //申请退款
    @RequestMapping("/refund")
    @ResponseBody
    public boolean refund(@RequestParam("orderId") String orderId, HttpSession session)
    {
        Order order = new Order();
        order.setOrderid(orderId);
        order.setOrderstatus(5);
        if(orderService.refund(order)!=0)
        {
            System.out.println("订单申请退款");
            User user = new User();
            user.setUserid((int)session.getAttribute("userId"));
            user.setUserscore(user.getUserscore()-(int)(order.getTotalprice()*0.1));
            if(userService.modifyUser(user)!=0)
                System.out.println("积分已回退");
            return true;
        }
        else
        {
            System.out.println("订单申请退款失败");
            return false;
        }
    }
}
