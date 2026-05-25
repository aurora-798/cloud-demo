package com.shuhang.controller;

import com.shuhang.model.Order;
import com.shuhang.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping
    public Order getOrderById(@RequestParam("orderId") Long orderId,
                              @RequestParam("userId") Long userId){
        return orderService.getOrderById(orderId,userId);
    }
}
