package com.boss.log.aspect;

import com.boss.log.aspect.annotation.ActionLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.boss.log.service.impl.*.*(..)) && @annotation(com.boss.log.aspect.annotation.ActionLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint){
        String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String methodName=joinPoint.getSignature().getName();
        String className=joinPoint.getSignature().getDeclaringTypeName();
        Object[] argArray=joinPoint.getArgs();
        ActionLog actionLog=getMethodAnnotation(joinPoint);
        String action=actionLog.action();
        String desc=actionLog.desc();
        String errMsg=null;
        Object result=null;
        boolean isNormalExecution=true;
        long startTime=System.currentTimeMillis();
        try {
            result=joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            errMsg=throwable.getMessage();
            isNormalExecution=false;
        }
        long duration=System.currentTimeMillis()-startTime;

//        System.out.println("time:"+datetime);
//        System.out.println("className:"+className);
//        System.out.println("methodName:"+methodName);
//        System.out.println("annotation action:"+action);
//        System.out.println("annotation desc:"+desc);
//        System.out.println("args:"+ Arrays.asList(argArray));
//        System.out.println("execution status:"+(isNormalExecution?"Return Normally":"Has error"));
//        if(isNormalExecution){
//            System.out.println("return value:"+result);
//        }else{
//            System.out.println("error message:"+errMsg);
//        }
//        System.out.println("elapsed time:"+duration+"ms");

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("time",datetime);
        map.put("className",className);
        map.put("methodName",datetime);
        map.put("annotation action",action);
        map.put("annotation desc",desc);
        map.put("args",Arrays.asList(argArray));
        map.put("execution status",(isNormalExecution?"Return Normally":"Has error"));
        map.put("return value",result);
        map.put("error message",errMsg);
        map.put("elapsed time",duration+"ms");
        System.out.println(map);

        return result;
    }

    private ActionLog getMethodAnnotation(JoinPoint joinPoint){
        Method method = null;
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        try {
            method = joinPoint.getTarget().getClass()
                .getMethod(joinPoint.getSignature().getName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
        return method.getAnnotation(ActionLog.class);
    }
}
