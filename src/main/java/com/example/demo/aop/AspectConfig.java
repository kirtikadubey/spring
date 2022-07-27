package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class AspectConfig {


    private Logger log = LoggerFactory.getLogger(AspectConfig.class);
    @Before(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
      log.error("Before execution {}",joinPoint);
    }

    @After(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        log.error("After execution {}",joinPoint);
    }
    @Around(value = "execution(* com.example.demo.controller.*.*(..))")
    public void totalExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
         long startTime = System.currentTimeMillis();
         try {
             log.info("GOINF FOR EXECUTION NOW BFR:AFTER");
             Object object = proceedingJoinPoint.proceed();
            long  endTime = System.currentTimeMillis();
            log.info("TOTAL EXECUTION TIMING {}",endTime-startTime);
         }
         catch (Exception e){
             log.error("EXCEPTION GENERATED {}",e.getCause());
         }
    }
}
