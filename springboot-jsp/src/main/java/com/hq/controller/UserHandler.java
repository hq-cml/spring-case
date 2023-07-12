package com.hq.controller;

import com.hq.entity.User;
import com.hq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll") // Note: Get请求
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user"); // Note：访问/user.jsp
        modelAndView.addObject("list",userService.findAll());
        return modelAndView;
    }
    @GetMapping("findById/{id}") // Note: 带参数
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/save") // Note: Post请求接口
    public String save(User user){
        userService.save(user);
        return "redirect:/user/findAll";// Note: 重定向
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user/findAll";
    }
    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/findAll";
    }
}