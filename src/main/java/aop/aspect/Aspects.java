package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class Aspects {
    @Pointcut ("execution(* aop.demo.AccountDao.findAccount(..))")
     public void findAccount(){
    }



}
