package com.boss.aop.service.impl;

import com.boss.aop.service.ILoginService;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
public class TestService implements ILoginService {
    @Foo(action = "login",description = "common user login")
    public boolean login(String username, String password){
        if(username==null || password==null){
            throw new IllegalArgumentException("username or password cannot be null!");
        }
        System.out.println("TestService");
        if("admin".equals(username) && "123456".equals(password)){
            return true;
        }
        return false;
    }
}

