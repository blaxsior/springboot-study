package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// Pointcut만 있다면 필요 X. advice 추가할 때는 필요
public class AopExp {
    // 프로젝트 내 다른 위치에서 사용 가능!
    @Pointcut("execution(* com.example.demo..dao.*.*(..))")
    public void daoPointcut() {}

    @Pointcut("execution(* com.example..demo..dao.*.get*(..))")
    public void getterPointCut() {}

    @Pointcut("execution(* com.example..demo..dao.*.set*(..))")
    public void setterPointCut() {}

    @Pointcut("getterPointCut() || setterPointCut()")
    public void getterOrSetterPointCut() {}
}
