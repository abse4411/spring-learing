package com.boss.proxy.component;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object sourceObject;

    public Object newInstance(Object source) {
        sourceObject=source;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(source.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoking "+method.getName());
        Object result = method.invoke(sourceObject, args);
        System.out.println("After invoking "+method.getName());
        return result;
    }
}
