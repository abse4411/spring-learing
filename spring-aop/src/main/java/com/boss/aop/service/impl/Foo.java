package com.boss.aop.service.impl;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Foo{
    public String action();
    public String description();
}
