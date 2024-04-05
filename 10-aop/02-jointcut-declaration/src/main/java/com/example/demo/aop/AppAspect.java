package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
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

//    @Before("execution(* add*())")
//    public void beforeAddSomethingAdvice2() {
//        System.out.println("[@Before(\"execution(* add*())\")]");
//    }
//
//    @Before("execution(* add*(com.example.demo..entity.Account))")
//    public void beforeAnyReturnAddSomethingAnyParamAdvice() {
//        System.out.println("[@Before(\"execution(* add*(*..entity.Account))\")]");
//    }
//
//    @Before("execution(* add*(com.example.demo..entity.Account,*,..))")
//    public void beforeAnyReturnAddSomethingAnyParamsAdvice() {
//        System.out.println("[@Before(\"execution(* add*(*..entity.Account, ..))\")]");
//    }

//    @Before("daoPointcut()")
//    public void beforeDaoFunctions(JoinPoint point) {
//        var signature = point.getSignature().getName();
//        System.out.println("- signature = " + signature + " -");
//    }
//
//    @Before("daoPointcut() && !(getterOrSettorPointCut())")
//    public void performExceptGetSet() {
//        System.out.println("[perform except getter or setter]");
//    }

    @Before("com.example.demo.aop.AopExp.getterOrSetterPointCut()")
    public void performGetSet1() {
        System.out.println("[GETTER/SETTER 111]");
    }

}
