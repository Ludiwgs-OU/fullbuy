package com.we.fullbuy.controller;

import com.we.fullbuy.pojo.Address;
import com.we.fullbuy.pojo.Order;
import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.pojo.Sku;
import com.we.fullbuy.service.AddressService;
import com.we.fullbuy.service.OrderService;
import com.we.fullbuy.service.ProductService;
import com.we.fullbuy.service.SkuService;
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

    //生成普通订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public int addOrder(@RequestParam("skuId") int skuId, @RequestParam("num") int num, HttpSession session) {

        int userId = (int) session.getAttribute("userId");
        String cdate = Long.toString(System.currentTimeMillis());
        String orderId = userId + cdate;
        System.out.println("订单编号：" + orderId);

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Sku sku = skuService.showSku(skuId);
        if(num<sku.getQuantity())
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
                    System.out.println("sku Success");

                Product product = new Product();
                product.setProductid(sku.getProductid());
                product.setSalesnum(product.getSalesnum()+num);
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

    //订单详情
    @RequestMapping("/displayOrderDetail")
    @ResponseBody
    public Order displayOrderDetail(@RequestParam("orderId") String orderId)
    {
        return orderService.showOrderDetail(orderId);
    }

    /*删除订单*/
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
    public boolean pay(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderid(orderId);
        order.setOrderstatus(1);
        if(orderService.Pay(order)!=0)
        {
            System.out.println("订单已支付");
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
    public boolean refund(@RequestParam("orderId") String orderId)
    {
        Order order = new Order();
        order.setOrderid(orderId);
        order.setOrderstatus(5);
        if(orderService.refund(order)!=0)
        {
            System.out.println("订单申请退款");
            return true;
        }
        else
        {
            System.out.println("订单申请退款失败");
            return false;
        }
    }
}
