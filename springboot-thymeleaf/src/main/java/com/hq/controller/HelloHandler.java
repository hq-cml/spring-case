package com.hq.controller;

import com.hq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/hello")
public class HelloHandler {
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name","张三");
        return modelAndView;
    }

    @GetMapping("/if")
    public ModelAndView ifTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/unless")
    public ModelAndView unlessTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/switch")
    public ModelAndView switchTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("studentId",1);
        return modelAndView;
    }

    @GetMapping("/redirect/{url}")
    public String redirect(@PathVariable("url") String url, Model model){
        model.addAttribute("url","/hello/login");
        return url;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "login";
    }

    @GetMapping("/each")
    public ModelAndView each(){
        List<User> list = Arrays.asList(
                new User(1,"张三"),
                new User(2,"李四"),
                new User(3,"王五"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/value")
    public ModelAndView value(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("value","Spring Boot");
        return modelAndView;
    }

    @GetMapping("/src")
    public ModelAndView src(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("src","/1.png");
        return modelAndView;
    }

    @GetMapping("/href")
    public ModelAndView href(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("href","https://www.baidu.com");
        return modelAndView;
    }

    @GetMapping("/select")
    public ModelAndView select(){
        List<User> list = Arrays.asList(
                new User(1,"张三"),
                new User(2,"李四"),
                new User(3,"王五")
        );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list",list);
        modelAndView.addObject("name","李四");
        return modelAndView;
    }

    @GetMapping("/attr")
    public ModelAndView attr(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("attr","Spring Boot");
        return modelAndView;
    }

    @GetMapping("/servlet")
    public String servlet(HttpServletRequest request){
        request.setAttribute("value","request");
        request.getSession().setAttribute("value","session");
        request.getServletContext().setAttribute("value","servletContext");
        return "test";
    }

    @GetMapping("/servlet2")
    public ModelAndView servlet2(HttpSession session){
        session.setAttribute("name","李四");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("name","张三");
        return modelAndView;
    }

    @GetMapping("/utility")
    public ModelAndView utility(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("utility");
        modelAndView.addObject("date",new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,1,1);
        modelAndView.addObject("calendar",calendar);
        modelAndView.addObject("number",0.06);
        modelAndView.addObject("string","Spring Boot");
        modelAndView.addObject("boolean",true);
        modelAndView.addObject("array",Arrays.asList("张三","李四","王五"));
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三"));
        list.add(new User(2,"李四"));
        modelAndView.addObject("list",list);
        Set<User> set = new HashSet<>();
        set.add(new User(1,"张三"));
        set.add(new User(2,"李四"));
        modelAndView.addObject("set",set);
        Map<Integer,User> map = new HashMap<>();
        map.put(1,new User(1,"张三"));
        map.put(2,new User(2,"李四"));
        modelAndView.addObject("map",map);
        return modelAndView;
    }


}