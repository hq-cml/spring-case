package com.hq.main;

import com.hq.entity.Classes;
import com.hq.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cases {
    public void Case1() {
        // Note: 传统方式，手动New
        Student stu = new Student();
        System.out.println(stu);

        // Note: Spring方式，利用Ioc来直接获取
        //       IoC容器自动创建对象，开发者只需要取出对象
        //       ApplicationContext可以简单理解为就是IoC的上下文，解析spring.xml文件，就会预先生成对象存于Ioc中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // Note: student是xml中的id
        // Note: 获取到的内容需要强制转换成为，因为getBean返回的Object类型对象
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);

        Student student2 = (Student)applicationContext.getBean("student2");
        System.out.println(student2);

        // Note: 根据类型取对象，需要提供运行时类
        //       此时就不在需要类型强转了，因为是基于类取出来的
        // Note: 根据类型取对象的弊端：如果spring.xml中有两个同类型的Bean，则会抛出异常
        /*
        Student student22 = applicationContext.getBean(Student.class); // Note: 提供运行时类
        System.out.println(student22);
         */

        Student student3 = (Student)applicationContext.getBean("student3");
        System.out.println(student3);
    }

    public void Case2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di.xml");
        // Note: 当前Ioc中所有的bean
        /*
        String[] names = applicationContext.getBeanDefinitionNames();
        for(String name:names) {
            System.out.println(name);
        }
         */
        Classes classes = (Classes) applicationContext.getBean("classes");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        System.out.println(classes);
    }
    public void Case3() {

    }
    public void Case4() {

    }
    public void Case5() {

    }
    public void Case6() {

    }
    public void Case7() {

    }
    public void Case8() {

    }
    public void Case9() {

    }


}
