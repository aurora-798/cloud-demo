package com.shuhang.service;

import com.shuhang.model.Order;

public interface OrderService {
    Order getOrderById(Long orderId,Long userId);
}
