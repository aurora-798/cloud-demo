package com.shuhang;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class OrderDiscoveryTest {

    @Resource
    DiscoveryClient discoveryClient;

    @Test
    void DiscoveryTest() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            // 获取服务名称
            System.out.println(service);
            //根据服务名称获取所有服务的实例
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip = " + instance.getHost() + "; port = " + instance.getPort());
            }
        }
    }
}
