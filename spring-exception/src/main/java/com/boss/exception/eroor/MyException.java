package com.boss.exception.eroor;

public class MyException extends RuntimeException{
    public MyException(IErrorResult errorResult){
        super("错误代码:"+errorResult.code()+" 错误摘要:"+errorResult.msg());
    }
    public MyException(Exception e){
        super("错误代码:-1"+" 错误摘要:"+e.getMessage());
    }
}
