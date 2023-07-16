package com.hq.controller;

import com.hq.entity.Student;
import com.hq.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {
    @Autowired
    private FeignProviderClient feignProviderClient;
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return feignProviderClient.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        feignProviderClient.save(student);
    }
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        feignProviderClient.update(student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        feignProviderClient.deleteById(id);
    }
}
