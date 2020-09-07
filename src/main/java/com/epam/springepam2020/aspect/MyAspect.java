package com.epam.springepam2020.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

    @Pointcut("execution(public * com.epam.springepam2020.service.impl.StormtrooperServiceImpl.*(..))")
    public void myPointcut() {
    }

    @Before("myPointcut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method name: " + methodName);
    }

    @After("myPointcut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        log.info("Method finished");
    }

    @Around("myPointcut()")
    @SneakyThrows
    public Object logMethod(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("executed time: " + executionTime + "ms");
        return proceed;
    }

}
