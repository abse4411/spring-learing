package com.boss.exception.aspect;

import com.boss.exception.eroor.ErrorResult;
import com.boss.exception.eroor.MyException;
import org.aspectj.lang.JoinPoint;

public class ExcceptionAspect {
    public void handleException(JoinPoint joinPoint,Exception e){
        System.out.println("Error in:"+joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName());
        System.out.println("With exception:"+e.getMessage());
        if(!(e instanceof MyException)){
            throw new MyException(e);
        }
    }


}
