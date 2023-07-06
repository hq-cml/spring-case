package com.hq.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// Note：负责生成动态代理类的类！
public class MyInvocationHandler implements InvocationHandler {
    // Note：将委托对象注入进来，委托对象用来实现真正的业务相关代码（非业务相关的交给代理类）
    private Object object = null;

    // Note：返回动态代理类的对象
    public Object bind(Object obj) {
        this.object = obj; // Note：将委托对象注入保存
        // Note：获取代理的实例化对象并返回
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(), //Note: 类加载器，负责将新生的动态代理类加载进Jvm，object.getClass()就是运行时类
                //MyInvocationHandler.class.getClassLoader(), Note: 这种写法也能获取到类加载器，MyInvocationHandler.class就是运行时类
                object.getClass().getInterfaces(),  //Note: 委托类的接口信息
                this); //Note: 谁来操作这个事情，通常就是this
    }

    // Note：调用方法：实现业务代码和非业务代码解耦合
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "的参数是" + Arrays.toString(args)); // Note：非业务代码
        Object result = method.invoke(this.object, args); // Note：调用业务代码
        System.out.println(method.getName() + "的结果是" + result.toString()); // Note：非业务代码
        return result;
    }
}
