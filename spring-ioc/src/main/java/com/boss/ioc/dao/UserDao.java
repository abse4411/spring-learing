package com.boss.ioc.dao;

import com.boss.ioc.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public int save(User user){
        System.out.println("UserDao:saving to db...");
        System.out.println("UserDao:done!");
        return 1;
    }
}
