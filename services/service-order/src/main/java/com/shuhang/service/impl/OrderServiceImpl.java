package com.shuhang.service.impl;

import com.shuhang.model.Order;
import com.shuhang.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderById(Long orderId, Long userId) {
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(userId);
        order.setAddress("杭州市");
        order.setNickName("zhangsan");
        // TODO 需要结合获取商品数据进行计算
        order.setTotalAmount(null);
        // TODO 需要获取商品数据
        order.setProductList(null);
        return order;
    }
}
