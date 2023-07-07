package com.hq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello") //Note: 路径和处理方法映射
public class HelloHandler {

    // Note: 返回值是string，最终用于逻辑视图=>物理视图
    @RequestMapping("/index") //Note: 路径和处理方法映射
    public String index() {
        System.out.println("接受到请求");
        // Note：返回逻辑视图
        //      视图的一个别名，最终会映射成一个物理视图，也就是jsp文件
        //      这个逻辑实在springmvc.xml中配置的
        return "index";
    }
}
