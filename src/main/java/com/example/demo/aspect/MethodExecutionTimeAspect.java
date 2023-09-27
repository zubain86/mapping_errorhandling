package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeAspect {

    private long startTime;

    @Before( "execution(* com.example.demo.controller.BillController.addBill(..))")
    public void beforeMethod1(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* com.example.demo.controller.BillController.getBill(..))")
    public void afterMethod1(JoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Method 1 executed in " + executionTime + "ms");
    }

}

