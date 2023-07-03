package com.hq.main;

import com.hq.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cases {
    public void Case1() {
        // 传统方式，手动New
        Student stu = new Student();
        System.out.println(stu);

        // Spring方式，利用Ioc来直接获取
        // IoC容器自动创建对象，开发者只需要取出对象
        // Note: ApplicationContext可以简单理解为就是IoC的上下文，解析spring.xml文件，就会预先生成对象存于Ioc中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // Note: student是xml中的id
        // Note: 获取到的内容需要强制转换成为，因为getBean返回的Object类型对象
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
