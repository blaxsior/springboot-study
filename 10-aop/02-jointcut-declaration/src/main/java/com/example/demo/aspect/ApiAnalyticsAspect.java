package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {
    @Before("com.example.demo.aspect.AopExp.getterOrSetterPointCut()")
    public void performGetSet3() {
        System.out.println("[GETTER/SETTER 333]");
    }

    @Before("execution(* com.example.demo..*(..))")
    public void methodExecutionAdvice(JoinPoint joinPoint) {
        // 메서드 시그니처 출력
        var signature = joinPoint.getSignature();

        System.out.println("Method: " + signature);
        //메서드 매개변수 출력
        var args = joinPoint.getArgs();

        for(var i = 0; i < args.length; i++) {
            System.out.printf("arg[%d]: %s\n", i, args[i]);
        }
    }
}
