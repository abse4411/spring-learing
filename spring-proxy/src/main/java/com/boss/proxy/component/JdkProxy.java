package com.boss.proxy.component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object sourceObject;

    public Object newInstance(Object source) {
        sourceObject=source;
        return Proxy.newProxyInstance(source.getClass().getClassLoader(),
            source.getClass().getInterfaces(),
            this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoking "+method.getName());
        Object result = method.invoke(sourceObject, args);
        System.out.println("After invoking "+method.getName());
        return result;
    }
}
