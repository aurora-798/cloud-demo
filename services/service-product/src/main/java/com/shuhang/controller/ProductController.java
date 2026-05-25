package com.shuhang.controller;


import com.shuhang.model.product.Product;
import com.shuhang.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        return productService.getProductById(productId);
    }
}
