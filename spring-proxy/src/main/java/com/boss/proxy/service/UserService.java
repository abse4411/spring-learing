package com.boss.proxy.service;

import com.boss.proxy.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class UserService implements IUserService{

    public UserService() {
        System.out.println("UserService is constructing...");
    }

    public String saveUser(User user){
        System.out.println("saveUser：User name:"+user.getName());
        System.out.println("saveUser：User age:"+user.getAge());
        return "success";
    }
}
