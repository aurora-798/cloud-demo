package com.shuhang.service;


import com.shuhang.model.order.Order;

public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
