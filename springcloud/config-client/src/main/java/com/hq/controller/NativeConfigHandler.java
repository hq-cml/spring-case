package com.hq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigHandler {
    // Note：Value注解读取，看起来读取本地配置，实质上读取的server的配置文件
    @Value("${server.port}")
    private String port;
    @Value("${foo}")
    private String foo;
    @GetMapping("/index")
    public String index(){
        return this.port+"-"+this.foo;
    }
}
