package com.hq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {
    // Note: 切面方法，这个@Before注解表示要在CalImpl.add方法之前调用
    //       add方法不能只写add，还要带上类路径
    //@Before("execution(public int com.hq.aop.impl.CalImpl.add(..))")
    @Before("execution(public int com.hq.aop.impl.CalImpl.*(..))") // Note: 用*表示任意方法
    public void before(JoinPoint joinpoint) {
        // Note: JoinPoint是连接点，连接了委托类和切面类
        //       通过这个连接点可以获取函数名字和参数值
        String name = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        System.out.println(name+"方法的参数是"+args);
    }

    // 在返回前
    //@After("execution(public int com.hq.aop.impl.CalImpl.add(..))")
    @After("execution(public int com.hq.aop.impl.CalImpl.*(..))")
    public void after(JoinPoint joinpoint) {
        String name = joinpoint.getSignature().getName();
        System.out.println(name+"方法的参数执行完毕");
    }

    // 在返回后
    // Note: 这里使用到了注解的第二个参数，值为result，正好对应参数的第二个参数，名字必须也是result
    //@AfterReturning(value="execution(public int com.hq.aop.impl.CalImpl.add(..))", returning = "result")
    @AfterReturning(value="execution(public int com.hq.aop.impl.CalImpl.*(..))", returning = "result")
    public void afterReturn(JoinPoint joinpoint, Object result) {
        String name = joinpoint.getSignature().getName();
        System.out.println(name+"的结果是" + result); //Note: 直接通过result来得到结果
    }

    // 在异常后
    //@AfterThrowing(value="execution(public int com.hq.aop.impl.CalImpl.add(..))", throwing = "ex")
    @AfterThrowing(value="execution(public int com.hq.aop.impl.CalImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinpoint, Exception ex) {
        String name = joinpoint.getSignature().getName();
        System.out.println(name+"出现异常" + ex); //Note: 直接通过ex来得到异常
    }
}
