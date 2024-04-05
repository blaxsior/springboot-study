package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(2)
public class CloudLogAspect {

    @Before("com.example.demo.aspect.AopExp.getterOrSetterPointCut()")
    public void performGetSet2() {
        System.out.println("[GETTER/SETTER 222]");
    }
}
