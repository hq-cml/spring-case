package com.hq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /*
    // Note：注入RestTemplate配置类的Bean到Ioc容器
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
     */
}