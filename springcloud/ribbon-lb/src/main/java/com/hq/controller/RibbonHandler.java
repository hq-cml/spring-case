package com.hq.controller;

import com.hq.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {

    // Note: 自动装载，已经在Main里面注入过了
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        // Note：第一个provider是注册中的服务名字（不再需要ip地址），这个才是真正的服务发现啊
        // Note：第二个provider是路径
        // Note: 负载均衡，如果provider服务由多个实例，则会自动负载均衡
        return restTemplate.getForObject("http://provider/provider/findAll",Collection.class);
    }
}
