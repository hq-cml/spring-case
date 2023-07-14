package com.hq.controller;

import com.hq.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class StudentHandler {

    // Note: MyConfig里面已经注入了，这里就可以直接装载进来
    @Autowired
    private RestTemplate restTemplate; // Note: 这东西就类似于Go里面的client了

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        // Note: 发送get请求
        return restTemplate.getForObject("http://localhost:8010/provider/findAll", // Note: url地址
                Collection.class // Note: 指定类型
        );
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject("http://localhost:8010/provider/findById/{id}",
                Student.class,
                id
        );
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/provider/save",
                student,
                Student.class // Note: 指定返回值类型
        );
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/provider/update",
                student
        );
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8010/provider/deleteById/{id}",
                id
        );
    }
}