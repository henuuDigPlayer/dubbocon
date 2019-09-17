package com.lindj.dubbo.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lindj
 * @Description 启动类
 * @date 2018/4/11 0011
 */
@SpringBootApplication
@MapperScan("com.lindj.dubbo.consumer.mapper")
@ComponentScan(value = {"com.zjdex", "com.lindj.dubbo.consumer"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}