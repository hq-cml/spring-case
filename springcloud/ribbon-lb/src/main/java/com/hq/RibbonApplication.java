package com.hq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Note: 启动类
@SpringBootApplication
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    // Note：注册rpcClient的Bean对象到Ioc
    @Bean
    @LoadBalanced // Note: 这个注解，就让rpcClient自动有了负载均衡的功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}