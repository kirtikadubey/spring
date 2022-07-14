package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BfrAspect {

    @Before("aop.aspect.Aspects.findAccount()")
    void adviceAftrFindAccount(JoinPoint jp){
        String Method_name = jp.getSignature().getName();
        Object usrName = jp.getArgs();
        System.out.println("This is BFR advice invoked for :" +Method_name +usrName);
    }
}
