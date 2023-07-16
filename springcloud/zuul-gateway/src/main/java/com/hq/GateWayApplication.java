package com.hq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// Note: 启动类
@EnableZuulProxy
@EnableAutoConfiguration // Note: 这个注解实际上是@SpringBootApplication的一部分，已够用
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}