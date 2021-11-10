package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class MyAspect {

    //创建连接点
    //通俗点Aop的作用就是对用户的操作进行了批量的监听
    //例如这里可以对impl中的所有文件进行一个监听
    @Pointcut("execution(* com.example..*.service.impl.*.*(..))")
    public void pc(){

    }
    @Before("pc()")
    public boolean before(JoinPoint jp){
        System.out.println( "before");
        return true;
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object result = pjp.proceed();

        System.out.println(new Date() +"使用了参数"+ Arrays.toString(pjp.getArgs())+"执行了"
        +pjp.getSignature().getName()+"得到了"+result+"结果");
        return result;
    }

    @AfterReturning(pointcut = "pc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("afterReturning");
    }

    @AfterThrowing(pointcut = "pc()",throwing = "e")
    public void afterReturning(JoinPoint joinPoint,Exception e){
        System.out.println( "afterReturning");
    }

}
