package com.boss.log.service.impl;

import com.boss.log.aspect.annotation.ActionLog;
import com.boss.log.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @ActionLog(action = "登录",desc = "从网站登录入口")
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
