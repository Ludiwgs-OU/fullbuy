package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.*;
import com.we.fullbuy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    private ProductService productService;
    @Resource
    private UserService userService;
    @Resource
    private AddressService addressService;
    @Resource
    private GroudbuyService groudbuyService;

    //确认订单信息
    @RequestMapping("/checkOrder")
    @ResponseBody
    public String checkOrder(@RequestParam("skuId") int skuId,
                           @RequestParam("num") int num,
                           @RequestParam("price") double price,
                           @RequestParam("gbId") int gbId,
                           HttpSession session, RedirectAttributes attributes)
    {
        Product product = productService.searchBySkuId(skuId);
        List<Address> address = addressService.displayAddress((int) session.getAttribute("userId"));
        List list  = new ArrayList();
        list.add(product);
        list.add(address);
        list.add(num);
        list.add(price);
        list.add(gbId);
        attributes.addAttribute("list",list);

        return "redirect:/Order/preOrder";

    }

    //返回订单信息列表
    @RequestMapping("/preOrder")
    @ResponseBody
    public List preOrder(@RequestParam("list") List list)
    {
        return list;
    }


    //生成普通订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder(@RequestParam("skuId") int skuId,
                           @RequestParam("addressId") int addressId,
                           @RequestParam("num") int num,
                           @RequestParam("price") double price,
                           @RequestParam("totalPrice") double totalPrice,
                           @RequestParam("orderStatus") int orderStatus,
                           @RequestParam("gbId") int gbId,
                        HttpSession session) {

        //生成订单编号
        int userId = (int) session.getAttribute("userId");
        String cdate = Long.toString(System.currentTimeMillis());
        String orderId = userId + cdate;
        System.out.println("订单编号：" + orderId);

        //时间格式转换
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Sku sku = skuService.showSku(skuId);
        if(num<sku.getQuantity())//库存量比较
        {
            Order order = new Order();
            order.setOrderId(orderId);
            order.setOrderDate(timestamp);
            order.setOrderStatus(orderStatus);
            order.setNum(num);
            order.setUserId(userId);
            order.setPrice(price);
            order.setTotalPrice(totalPrice);
            order.setAddressId(addressId);
            order.setSkuId(skuId);
            if(orderService.addOrder(order)==1)
            {
                if(orderStatus==1)
                {
                    sku.setQuantity(sku.getQuantity()-num);
                    int s = skuService.updateSku(sku);
                    if(s!=0)
                        System.out.println("-Quantity Success");//减库存量

                    Product product = new Product();
                    product.setProductId(sku.getProductId());
                    product.setSalesNum(product.getSalesNum()+num);//增加销售量
                    int p = productService.modifyProduct(product);
                    if(p!=0)
                        System.out.println("+Salesnum success");

                    if(gbId!=0)
                    {
                        Groudbuy groudbuy = new Groudbuy();
                        groudbuy.setGbId(gbId);
                        groudbuy.setNowPeople(groudbuy.getNowPeople()+1);
                        groudbuyService.modifyGroudbuy(groudbuy);
                    }


                }

                return orderId;//订单生成成功
            }
            else
                return "订单生成失败";//订单生成失败
        }
        else
            return "库存量不足";//库存量不足
    }


    //显示商家的订单列表
    @RequestMapping("/displaySalesOrder")
    @ResponseBody
    public List<Order> displaySalesOrder(HttpSession session){
        return orderService.showSalesOrder((int)session.getAttribute("salesId"));
    }

    //显示用户的订单列表
    @RequestMapping("/displayUserOrder")
    @ResponseBody
    public List<Order> displayUserOrder(HttpSession session){
        return orderService.showUserOrder((int)session.getAttribute("userId"));
    }

    //订单详情
    @RequestMapping("/displayOrderDetail/{orderId}")
    @ResponseBody
    public Order displayOrderDetail(@PathVariable("orderId") String orderId)
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
    public String pay(@RequestParam("orderId") String orderId, HttpSession session)
    {
        Order order = orderService.showOrderDetail(orderId);
        order.setOrderStatus(1);
        if(orderService.Pay(order)!=0)
        {
            User user = new User();
            user.setUserId((int)session.getAttribute("userId"));
            user.setUserScore(user.getUserScore()+(int)(order.getTotalPrice()*0.1));
            userService.modifyUser(user);
            return "订单已支付";
        }

        else
            return "订单支付失败";
    }

    //确认收货
    @RequestMapping("/confirm")
    @ResponseBody
    public String confirm(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(3);
        if(orderService.confirm(order)!=0)
            return "已确认收货咯";
        else
            return "订单收货失败";
    }

    //申请退款
    @RequestMapping("/refund")
    @ResponseBody
    public String refund(@RequestParam("orderId") String orderId, HttpSession session)
    {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(5);
        if(orderService.refund(order)!=0)
        {
            User user = new User();
            user.setUserId((int)session.getAttribute("userId"));
            user.setUserScore(user.getUserScore()-(int)(order.getTotalPrice()*0.1));
            userService.modifyUser(user);
            return "订单申请退款并积分已回退";
        }
        else
            return "订单申请退款失败";
    }
}
