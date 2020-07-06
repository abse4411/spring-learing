package com.boss.aop.aspect;

import com.boss.aop.service.impl.Foo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(* com.boss.aop.service.impl.*.*(..))")
    public void pointcut() {
    }

    ;

    @Before("pointcut()")
    public void beforeLogin(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();

        MethodSignature methodSignature = (MethodSignature) signature;
        Method method1 = methodSignature.getMethod();

        Method method = null;
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        try {
            method = joinPoint.getTarget().getClass()
                .getMethod(joinPoint.getSignature().getName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("Before:" + signature);
        System.out.println("Before:ArgValueList:" + Arrays.asList(joinPoint.getArgs()));
        if (method != null) {
            System.out.println("Before:Annotation:" + Arrays.asList(method.getAnnotations()));
            System.out.println(method);
            System.out.println(method1);
        }


    }

    @After("pointcut()")
    public void afterLogin(JoinPoint joinPoint) {
        System.out.println("After:" + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void returnResult(JoinPoint joinPoint, Object result) {
        System.out.println("Return:Result:" + result);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void handleError(JoinPoint joinPoint, Exception e) {
        System.out.println("Error:Error in:" + joinPoint.getSignature());
        System.out.println("Error:With exception:" + e.getMessage());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("Around：Ready to invoke...");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Around:Invocation result:" + result);
            return result;
        } catch (Throwable throwable) {
            System.out.println("Around：Error in invocation");
            throwable.printStackTrace();
        }
        return result;
    }
}
