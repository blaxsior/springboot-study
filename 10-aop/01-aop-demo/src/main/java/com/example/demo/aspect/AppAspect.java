package com.example.demo.aspect;

import com.example.demo.account.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppAspect {
//    @Before("execution(public void com.example.demo.account.dao.AccountDao.addAccount())") // point cut
//    public void beforeAddAccountAdvice() { // Advice
//        System.out.println("[@Before(\"execution(public void com.example.demo.account.dao.AccountDao.addAccount())\")]");
//    }
//
//    @Before("execution(public void com.example.demo.account.dao.AccountDao.add*())") // point cut
//    public void beforeAddSomethingInAccountDaoAdvice() { // Advice
//        System.out.println("[@Before(\"execution(public void com.example.demo.account.dao.AccountDao.add*())\")]");
//    }
//
//    @Before("execution(void add*())") // point cut
//    public void beforeAddSomethingAdvice() { // Advice
//        System.out.println("[@Before(\"execution(void add*())\")]");
//    }

    @Before("execution(* add*())")
    public void beforeAddSomethingAdvice2() {
        System.out.println("[@Before(\"execution(* add*())\")]");
    }

    @Before("execution(* add*(com.example.demo..entity.Account))")
    public void beforeAnyReturnAddSomethingAnyParamAdvice() {
        System.out.println("[@Before(\"execution(* add*(*..entity.Account))\")]");
    }

    @Before("execution(* add*(com.example.demo..entity.Account,*,..))")
    public void beforeAnyReturnAddSomethingAnyParamsAdvice() {
        System.out.println("[@Before(\"execution(* add*(*..entity.Account, ..))\")]");
    }
}
