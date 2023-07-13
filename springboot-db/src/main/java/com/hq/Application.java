package com.hq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hq.repository.mybatis") // Note: Mybatis需要用到，扫描包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}