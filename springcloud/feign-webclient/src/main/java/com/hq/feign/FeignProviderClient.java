package com.hq.feign;

import com.hq.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// Note：只需要声明一个接口
@FeignClient("provider") // Note：value=服务提供者在注册中心的名字
public interface FeignProviderClient {
    // Note：下面这些，可以理解为就是代理转发规则的配置！
    @GetMapping("/provider/findAll")
    public Collection<Student> findAll();
    @GetMapping("/provider/findById/{id}")
    public Student findById(@PathVariable("id") Integer id);
    @PostMapping("/provider/save")
    public void save(@RequestBody Student student);
    @PutMapping("/provider/update")
    public void update(@RequestBody Student student);
    @DeleteMapping("/provider/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id);
}
