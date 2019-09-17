package com.lindj.dubbo.consumer.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lindj
 * @date 2019/9/16 0016
 * @description
 */
@Data
@ToString
@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
public class ConsumerConfig {
    private String groupName;
    private String namesrvAddr;
}
