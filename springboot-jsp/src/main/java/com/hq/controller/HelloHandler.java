package com.hq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Note: 这里的注解是@Controller
//       RestController和Controller的区别：前者是一个纯数据接口，后者是一个带视图的链接入口
@Controller
@RequestMapping("/hello")
public class HelloHandler {

    // Note: 一个Jsp的接口连接，返回ModelAndView
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        // Note: 这里最终会映射成为/index.jsp文件
        modelAndView.setViewName("index");
        // Note：页面赋值msg变量
        modelAndView.addObject("msg","Hello Jsp");
        return modelAndView;
    }
}