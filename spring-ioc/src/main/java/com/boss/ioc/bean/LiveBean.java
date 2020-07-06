package com.boss.ioc.bean;

public class LiveBean {
    public LiveBean() {
        System.out.println("LiveBean is constructing...");
    }

    //初始化时bean调用
    //@PostConstruct
    public void init() {
        System.out.println("LiveBean is been initializing...");

    }

    //销毁时bean调用
    //@PreDestroy
    public void destroy() {
        System.out.println("LiveBean was destroyed...");

    }
}
