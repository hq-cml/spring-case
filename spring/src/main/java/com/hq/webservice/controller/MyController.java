package com.hq.webservice.controller;

import com.hq.webservice.service.MyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
//@Component //Note: @Component不如专用的@Ctroller好
@Controller
public class MyController {
    @Autowired
    private MyService myService;

    // 模拟处理客户端请求：根据成绩得到名次
    public String service(Double score) {
        return myService.doService(score);
    }
}
