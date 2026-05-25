package com.shuhang.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order")
@Data
public class OrderServiceYmlConfig {
    private String timeout;
}
