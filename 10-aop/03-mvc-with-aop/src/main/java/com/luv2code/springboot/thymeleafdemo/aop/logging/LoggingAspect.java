package com.luv2code.springboot.thymeleafdemo.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo..controller.*.*(..))")
    private void controllerPointcut() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo..service.*.*(..))")
    private void servicePointcut() {}
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo..dao.*.*(..))")
    private void daoPointcut() {}

    @Pointcut("controllerPointcut() || servicePointcut() || daoPointcut()")
    private void appFlowPointcut() {}

    @Before("appFlowPointcut()")
    public void before(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().toShortString();
        logger.info("[@Before calling method: " + method + "]");
        var args = joinPoint.getArgs();

        for(var arg: args) {
            logger.info("argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "appFlowPointcut()",
            returning = "result"
    )
    public void after(JoinPoint joinPoint, Object result) {
        logger.info("[@AfterReturning phase]");
        logger.info("result = " + result);
    }
}
