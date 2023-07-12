package com.hq.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Note: 最简单的接口，只需要一个Controller类
//      剩下的，一切都有默认约定（RestController和Controller的区别：前者是一个纯数据接口，后者是一个带视图的链接入口）
@RestController
@RequestMapping("/hello")
public class HelloHandler {

    // Note: 读取配置文件的信息
    //       基于SpEL Srping Expression Language
    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/index")
    public String index(){
        return "Hello World! " + port;
    }
}
