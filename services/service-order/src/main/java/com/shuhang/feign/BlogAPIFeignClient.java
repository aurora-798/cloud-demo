package com.shuhang.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "blog-server",url = "http://blog.codepure.cn")
public interface BlogAPIFeignClient {

    @PostMapping("/api/navMenu")
    String getBlogData();
}
