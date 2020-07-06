package com.boss.aop.service.impl;

import com.boss.aop.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
    public boolean login(String username, String password){
        if(username==null || password==null){
            throw new IllegalArgumentException("username or password cannot be null!");
        }
        if("admin".equals(username) && "123456".equals(password)){
            return true;
        }
        return false;
    }
}
