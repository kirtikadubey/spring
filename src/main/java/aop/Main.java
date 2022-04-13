package aop;

import aop.demo.AccountDao;
import aop.config.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDao acOb = context.getBean(AccountDao.class);
        acOb.findAccount();
    }
}
