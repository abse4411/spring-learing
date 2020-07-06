package com.boss.exception.service;

import com.boss.exception.bean.User;
import com.boss.exception.eroor.ErrorResult;
import com.boss.exception.eroor.MyException;

public class UserService{

    public String saveUser(User user) {
//        throw new RuntimeException("3123");
        boolean isIllegalInput=user==null || user.getPassword()==null || user.getName()==null;
        if(isIllegalInput){
            throw new MyException(ErrorResult.Illegal_INPUT);
        }

        boolean isVerifiable="admin".equals(user.getName()) && "123".equals(user.getPassword());
        if(!isIllegalInput){
            throw new MyException(ErrorResult.ACCESS_DENY);
        }

        return "success";
    }

}
