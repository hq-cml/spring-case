package com.hq.main;

import com.hq.entity.*;
import com.hq.factory.StaticCarFactory;
import com.hq.webservice.controller.MyController;
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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        // Note: scope作用域，单例模式，创建一次
        //        这是一种预加载模式！
        User user1 = (User) applicationContext.getBean("user1");
        User user2 = (User) applicationContext.getBean("user1");
        //System.out.println(user1.equals(user2));
        System.out.println(user1==user2); // Note：== 直接判断引用地址
        System.out.println("--------------------");

        // Note: scope作用域，prototype 原型模式
        //        非单例模式，创建两次
        //        这是一种lazy模式！
        User user3 = (User) applicationContext.getBean("user2");
        User user4 = (User) applicationContext.getBean("user2");
        //System.out.println(user3.equals(user4));
        System.out.println(user3==user4);
        System.out.println("--------------------");

        // Note: bean的继承
        User user5 = (User) applicationContext.getBean("user3");
        System.out.println(user5);
    }
    public void Case4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dependence.xml");
        // Note: 默认情况下由xml中bean的定义顺序来创建bean
    }
    public void Case5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        // Note: 最终效果，改了properties文件，xml自动更新！
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);

    }
    public void Case6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        // Note: 测试p命名空间
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
    public void Case7() {
        // Note：传统方式
        //Car car = StaticCarFactory.getCar(1);
        //System.out.println(car);

        // Note: 静态工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car = (Car) applicationContext.getBean("car1");
        System.out.println(car);

        // Note：实例工厂
        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);
    }
    public void Case8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autoware.xml");
        // ByName
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        // ByType
        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);
    }
    public void Case9() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
        // Note: 被自动注入的类，id是类名字将首字改成母小写！所以这里是repository
        Repository rp = (Repository) applicationContext.getBean("repository");
        System.out.println(rp);
    }
    public void Case10() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-webservice.xml");
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for(String name:names) {
//            System.out.println(name);
//        }

        MyController myController = applicationContext.getBean(MyController.class);
        String result = myController.service(new Double(85));
        System.out.println(result);
    }
}
