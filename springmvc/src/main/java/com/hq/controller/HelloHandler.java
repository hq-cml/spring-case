package com.hq.controller;

import com.hq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // Note: 设置一个POST接口
    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    public String index2() {
        System.out.println("接受到请求");
        return "index";
    }

    // Note: 指定固定参数
    @RequestMapping(value = "/post", method = RequestMethod.POST,
            params = {"id=1", "name=tom"}) //Note: 必须要id=1&name=tom
    public String post() {
        System.out.println("接受到请求");
        return "index";
    }

    // Note: 参数获取
    @RequestMapping(value = "/params", method = RequestMethod.POST)
    public String params(@RequestParam("id") Integer id, //Note: Spring MVC 可以⾃动完成数据类型转换，该⼯作是由 HandlerAdapter 来完成的
                         @RequestParam("name") String name ) {
        System.out.println("接受到请求："+id+", "+name);
        return "index";
    }

    // Note: Restful风格传参
    @RequestMapping(value = "/restful/{id}/{name}")
    public String restful(@PathVariable("id") Integer id,
                          @PathVariable("name") String name ) {
        System.out.println("接受到请求："+id+", "+name);
        return "index";
    }

    // Note: 取cookie值
    @RequestMapping("/cookie")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    // Note: POJO接收参数
    //       本质上是通过反射来实现的，将User拆开查看需要哪些参数，和穿过来的参数进行映射
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user){
        System.out.println(user);
        return "index";
    }
}
