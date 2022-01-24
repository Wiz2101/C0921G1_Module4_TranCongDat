package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    @AfterReturning (pointcut = "execution (* com.codegym.controller.BookController.*(..))")
    public void logMethodReturn(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method: " + name);
        System.err.println("Parameters: " + args);
    }
}
