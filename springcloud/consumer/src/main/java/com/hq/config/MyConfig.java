package com.hq.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Note:本质上是利用了@SpringBootApplication=>@SpringBootConfiguration=>@Configuration
//      注解的类，在这个类中，利用@Bean注解，可以将一个函数的返回值注入到Ioc
@Configuration
public class MyConfig {
    // Note: 这个注解其实就相当于Spring.xml里面的<bean></bean>
    //       只是这里用代码和注解的方式代替了xml配置
    //       类的名字就是函数名字，比如这里就是restTemplate
    //       可以通过context.getBean()查看到，根据类型或者名字都可以
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
