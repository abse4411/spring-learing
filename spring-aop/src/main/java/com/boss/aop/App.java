package com.boss.aop;

import com.boss.aop.service.ILoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //使用xml配置切面
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ILoginService loginService = context.getBean(ILoginService.class);
//        System.out.println("Normal:Login failed=========");
//        loginService.Login("213", "3");
//
//        System.out.println("Normal:Login success=========");
//        loginService.Login("admin", "123456");
//
//        System.out.println("Abnormal:Login error=========");
//        loginService.Login(null, "3");

        loadAnonatationApplicationContext();
    }
    //使用注解配置切面
    //切面类：@Aspect @Component
    //配置类：@Configuration @EnableAspectJAutoProxy
    private static void loadAnonatationApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.boss.aop");
        ILoginService loginService = context.getBean(ILoginService.class);
        System.out.println("Normal:Login failed=========");
        loginService.login("213", "3");

        System.out.println("Normal:Login success=========");
        loginService.login("admin", "123456");

        System.out.println("Abnormal:Login error=========");
        loginService.login(null, "3");
    }


}
