package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CountAspect {
    Long count=0L;
    @AfterReturning ("execution(* com.codegym.controller.BookController.*(..))")
    public Long countVisit(JoinPoint joinPoint){
        return count++;
    }
}
