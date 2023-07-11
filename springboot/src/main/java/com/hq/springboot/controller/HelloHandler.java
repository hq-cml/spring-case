package com.hq.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Note: 最简单的接口，只需要一个Controller类
//      剩下的，一切都有默认约定
@RestController
@RequestMapping("/hello")
public class HelloHandler {
    @RequestMapping("/index")
    public String index(){
        return "Hello World!";
    }
}
