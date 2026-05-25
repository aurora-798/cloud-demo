package com.shuhang.feign;

import com.shuhang.model.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-product")
public interface ProductFeignClient {

    // mvc 注解的 2 套逻辑。controller一套，feign一套。
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
