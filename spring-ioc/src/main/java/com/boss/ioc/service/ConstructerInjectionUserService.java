package com.boss.ioc.service;

import com.boss.ioc.bean.User;
import com.boss.ioc.dao.UserDao;

public class ConstructerInjectionUserService implements IUserService{
    private UserDao userDao;

    public ConstructerInjectionUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String saveUser(User user) {
        System.out.println("UserService:calling saveUser()");
        if (userDao != null){
            userDao.save(user);
        }
        System.out.println("UserService:done!");

        return "success";
    }
}
