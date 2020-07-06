package com.boss.ioc.service;

import com.boss.ioc.bean.User;
import com.boss.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class UserService implements IUserService{
    @Autowired
    UserDao userDao;

    public UserService() {
        System.out.println("UserService is constructing...");
    }

    public String saveUser(User user) {
        System.out.println("UserService:calling saveUser()");
        if (userDao != null) {
            userDao.save(user);
        }
        System.out.println("UserService:done!");

        return "success";
    }

    //初始化时bean调用
    @PostConstruct
    public void init() {
        System.out.println("UserService is been initializing...");

    }

    //销毁时bean调用
    @PreDestroy
    public void destroy() {
        System.out.println("UserService was destroyed...");

    }
}
