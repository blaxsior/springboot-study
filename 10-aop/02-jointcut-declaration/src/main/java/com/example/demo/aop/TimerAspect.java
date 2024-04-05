package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Aspect
@Component
public class TimerAspect {
    @Around("execution(* com.example.demo.TrafficFortune.service.TrafficFortuneService.getFortune(..))")
    public Object timerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[target method = " + joinPoint.getSignature().toShortString() + " ]");
        System.out.println("[before method start]");

        var start_time = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch(Exception e) {
            System.out.println("@Around Advice: exception occured... " + e);
            // throw new RuntimeException(e); // 에러를 다시 던질 수도 있다.
            result = "ERROR OCCURED";
        }

        var end_time = System.currentTimeMillis();
        long duration = end_time - start_time;

        System.out.println("[after method end]");
        System.out.println("[time: " + duration + "ms]");

        return result;
    }
}
