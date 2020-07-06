package com.boss.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoginAspect {

    public void beforeLogin(JoinPoint joinPoint){
        System.out.println("Before:"+joinPoint.getSignature());
        System.out.println("Before:ArgValueList:"+ Arrays.asList(joinPoint.getArgs()));
    }

    public void afterLogin(JoinPoint joinPoint){
        System.out.println("After:"+joinPoint.getSignature());
    }

    public void returnResult(JoinPoint joinPoint,Object result){
        System.out.println("Return:Result:"+result);
    }

    public void handleError(JoinPoint joinPoint,Exception e){
        System.out.println("Error:Error in:"+joinPoint.getSignature());
        System.out.println("Error:With exception:"+e.getMessage());
    }

    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("Around：Ready to invoke...");
        Object result = null;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("Around:Invocation result:"+result);
            return result;
        } catch (Throwable throwable) {
            System.out.println("Around：Error in invocation");
            throwable.printStackTrace();
        }
        return result;
    }
}
