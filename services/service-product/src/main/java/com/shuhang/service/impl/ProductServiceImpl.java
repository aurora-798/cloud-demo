package com.shuhang.service.impl;

import com.shuhang.model.Product;
import com.shuhang.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setProductName("iphone " + productId);
        product.setPrice(new BigDecimal("99.99"));
        product.setNum(1);
        return product;
    }
}
