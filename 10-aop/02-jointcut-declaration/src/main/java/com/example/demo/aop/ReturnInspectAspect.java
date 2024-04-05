package com.example.demo.aop;

import com.example.demo.account.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ReturnInspectAspect {

    @AfterReturning(
            pointcut = "execution(* com.example.demo.account.dao.AccountDao.findAccounts())",
            returning = "result"
    )
    public void inspectReturnValueOf_findAccountsFuncAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("[@AfterReturning, before modified]");
        if(result == null) return;

        result.forEach(it -> System.out.println(it));
        result.forEach(it -> it.setName("modified - " + it.getName()));
    }

    @Pointcut("execution(* com.example.demo.account.dao.AccountDao.findById(..))")
    public void findByIdAdvice() {}

    @AfterThrowing(
            pointcut = "findByIdAdvice()",
            throwing = "ex"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        System.out.println("[@AfterThrowing, error-handling]");
        System.out.println("exception: " + ex);
    }

    @After("findByIdAdvice()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("[@After: logging...]");
    }
}
