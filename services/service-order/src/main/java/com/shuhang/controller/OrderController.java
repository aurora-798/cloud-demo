package com.shuhang.controller;

import com.shuhang.model.order.Order;
import com.shuhang.service.OrderService;
import com.shuhang.yml.OrderServiceYmlConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope   // 实现动态刷新Nacos的配置
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderServiceYmlConfig orderServiceYmlConfig;

    @Resource
    private OrderService orderService;

    @GetMapping
    public Order create(@RequestParam("productId") Long productId,
                              @RequestParam("userId") Long userId){
        return orderService.createOrder(productId,userId);
    }

    @GetMapping("/bloginfo")
    public String getBlogInfo(){
        return orderService.getBlogData();
    }


    @GetMapping("/config")
    public String getOrderConfig() {
        return orderServiceYmlConfig.getTimeout();
    }
}
