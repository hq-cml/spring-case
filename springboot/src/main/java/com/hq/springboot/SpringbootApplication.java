package com.hq.springboot;

import com.hq.springboot.controller.HelloHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// Note: 启动类！！
//      原理解析：注解套注解，一层层解开，最终的效果就是扫描指定包路径（默认就是启动类所在包）下面所有的带了对应注解的类的bean进入IOC容器！
//      @SpringBootAppliction=> @SpringBootConfiguration
//                              这个注解主要负责使得启动类能够被加载到Ioc中，类似于@Controller功能
//                           => @EnableAutoConfiguration => @AutoConfigurationPackage => @Import({AutoConfigurationPackages.Registrar.class})
//                                                          负责自动装载组件到Ioc容器         获取当前类所在包及其子包，作为扫包的路径参数（默认值）
//                           => @ComponentScan
//                              持手动配置指定扫包路径参数，使用basePackages参数，如果配置了，那么优先级高于上面的默认值
//      总结，本质上来说，这个和Spring里面的基于注解开发是一回事，遵循两个基本步骤：
//           1. 配置自动扫包  2. 添加注解使得能够被注入Ioc
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
         SpringApplication.run(SpringbootApplication.class, args);

        /*
         * Note: Ioc里面，除了上面自己写的业务的类的bean，还会有大量的bean，下面的方法支持获取单个bean或者全部的bean名字
         *       ConfigurableApplicationContext上下文，可以简单理解为就是Ioc容器，和Spring是一样的

         * ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootApplication.class, args);

         * // Note: 获取单个Bean，根据运行实例额
         * HelloHandler helloHandler = configurableApplicationContext.getBean(HelloHandler.class);
         * System.out.println(helloHandler);

         * // Note: 获取全部bean的名字
         * String[] names = configurableApplicationContext.getBeanDefinitionNames();
         * for (String name:names) {
         *     System.out.println(name);
         * }
         */
    }
}
