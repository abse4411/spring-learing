package com.boss.ioc.service;

import com.boss.ioc.bean.User;
import com.boss.ioc.dao.UserDao;

public class PropertyInjectionUserService implements IUserService{
    private UserDao userDao;

    public String saveUser(User user) {
        System.out.println("UserService:calling saveUser()");
        if (userDao != null){
            userDao.save(user);
        }
        System.out.println("UserService:done!");

        return "success";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
