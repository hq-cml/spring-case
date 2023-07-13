package com.hq.controller;

import com.hq.entity.JapUser;
import com.hq.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("jpaHandler")
@RequestMapping("/jpauser")
public class JpaUserHandler {
    @Autowired
    private JpaUserRepository userRepository;
    @GetMapping("/findAll")
    public List<JapUser> findAll(){
        return userRepository.findAll();
    }
    @GetMapping("/findById/{id}")
    public JapUser findById(@PathVariable("id") Integer id){
        // Note: userRepository.findById(id)返回的是Optional类型
        //       这个类型的作用是防止空指针的报错，所以包了一层
        //       .get()方法则是拆开包，然后将真正的对象返回
        return userRepository.findById(id).get();
    }
    @PostMapping("/save")
    public void save(@RequestBody JapUser user){
        userRepository.save(user);
    }
    @PutMapping("/update")
    public void update(@RequestBody JapUser user){
        userRepository.save(user);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping("/findByUserName/{username}")
    public JapUser findByUserName(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }
}

