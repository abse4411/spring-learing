package com.boss.proxy;

import com.boss.proxy.bean.User;
import com.boss.proxy.component.CglibProxy;
import com.boss.proxy.component.JdkProxy;
import com.boss.proxy.service.FakeUserService;
import com.boss.proxy.service.IUserService;
import com.boss.proxy.service.UserService;

public class App {
    public static void main(String[] args) {
        User user=new User();
        user.setAge(1);
        user.setName("zhangsan");

        IUserService service=new UserService();
        FakeUserService service1=new FakeUserService();

        JdkProxy jdkProxy = new JdkProxy();
        CglibProxy cglibProxy = new CglibProxy();
        IUserService jdkProxyService = (IUserService)jdkProxy.newInstance(service);
        FakeUserService cglibProxyService1 = (FakeUserService)cglibProxy.newInstance(service1);

        String result = jdkProxyService.saveUser(user);
        System.out.println("result:"+result);
        System.out.println(service);
        System.out.println("=================");
        String result1 = cglibProxyService1.saveUser(user);
        System.out.println("result:"+result1);
        System.out.println(cglibProxyService1);
    }
}
