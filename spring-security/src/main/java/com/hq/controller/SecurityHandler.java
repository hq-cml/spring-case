package com.hq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityHandler {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
