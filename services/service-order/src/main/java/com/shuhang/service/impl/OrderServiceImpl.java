package com.shuhang.service.impl;

import com.shuhang.model.order.Order;
import com.shuhang.model.product.Product;
import com.shuhang.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product productData = getRemoteProductData(productId);
        // 远程调用获取商品数据
        Order order = new Order();
        order.setId(1L);
        order.setUserId(userId);
        order.setAddress("杭州市");
        order.setNickName("zhangsan");
        order.setTotalAmount(productData.getPrice().multiply(new BigDecimal(productData.getNum())));
        order.setProductList(List.of(productData));
        return order;
    }


    private Product getRemoteProductData(Long productId) {
        // 1. 获取商品服务的ip地址和端口号
        List<ServiceInstance> instances = discoveryClient.getInstances("server-product");
        ServiceInstance instance = instances.get(0);
        // 2. 发送请求
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        Product product = restTemplate.getForObject(url, Product.class);
        // 3. 获取响应的数据
        return product;
    }



}
