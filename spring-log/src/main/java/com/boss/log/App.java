package com.boss.log;

import com.boss.log.service.ILoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.boss.log");
        ILoginService loginService = context.getBean(ILoginService.class);
        System.out.println("Normal:Login failed=========");
        loginService.login("213", "3");

        System.out.println("Normal:Login success=========");
        loginService.login("admin", "123456");

        System.out.println("Abnormal:Login error=========");
        loginService.login(null, "3");
    }


}
