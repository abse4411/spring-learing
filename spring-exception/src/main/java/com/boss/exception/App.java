package com.boss.exception;

import com.boss.exception.bean.User;
import com.boss.exception.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        //userService.saveUser(null);
        userService.saveUser(new User("admin","1233"));
    }



}
