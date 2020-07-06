package com.boss.proxy.service;

import com.boss.proxy.bean.User;

public class FakeUserService {
    public String saveUser(User user){
        System.out.println("saveUser：User name:"+user.getName());
        System.out.println("saveUser：User age:"+user.getAge());
        return "success";
    }
}
