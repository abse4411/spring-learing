package com.boss.ioc;

import com.boss.ioc.bean.LiveBean;
import com.boss.ioc.bean.Student;
import com.boss.ioc.bean.User;
import com.boss.ioc.service.ConstructerInjectionUserService;
import com.boss.ioc.service.ISysService;
import com.boss.ioc.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context=new AnnotationConfigApplicationContext("com.boss.ioc");
//
//        for (int i = 0; i < 3; i++) {
//            UserService userService = context.getBean(UserService.class);
//            System.out.println("current UserService:"+userService);
//            if(userService!=null){
//                User user = new User();
//                user.setAge(12);
//                user.setName("张三");
//                userService.saveUser(user);
//                System.out.println("============");
//            }
//        }
//        User user=new User();
//        //对于单例bean会调用销毁方法
//        //而多实例对象销毁方法不会被调用而是由JVM GC回收
//        ((AnnotationConfigApplicationContext)context).close();

        //loadXmlBeanFactory();
        //loadXmlApplicationContext();
//        BeanLifeTimeTest();
//        constructerInjectionTest();
//        dataInjectionTest();
        propertyInjectionTest();
    }


    static void loadXmlBeanFactory() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        //在访问时创建bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        User user = new User();
        user.setAge(12);
        user.setName("张三");
        userService.saveUser(user);
    }

    static void loadClassPathApplicationContext() {
        //FileSystemXmlApplicationContext
        //AnnotationConfigApplicationContext
        //WebApplicationContext

        //在构建Application时创建bean
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setAge(12);
        user.setName("张三");
        userService.saveUser(user);
    }

    static void loadXmlApplicationContext() {
        ApplicationContext context =
            new FileSystemXmlApplicationContext("D:\\IntelliJ IDEA Projects\\spring-learing\\spring-ioc\\src\\main\\resources\\applicationContext.xml");

        ISysService sysService = (ISysService)context.getBean("sysService");
        System.out.println(sysService.getSysToken());
    }
    static void BeanLifeTimeTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        for (int i = 0; i < 3; i++) {
            LiveBean bean=(LiveBean)context.getBean("liveBean");
            System.out.println(bean);
        }
        //而多实例对象销毁方法不会被调用而是由JVM GC回收
        System.out.println("destroying ClassPathXmlApplicationContext...");
        ((ClassPathXmlApplicationContext)context).close();
    }
    static void constructerInjectionTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConstructerInjectionUserService service=
            (ConstructerInjectionUserService)context.getBean(ConstructerInjectionUserService.class);
        User user = new User();
        user.setAge(12);
        user.setName("张三");
        service.saveUser(user);
    }
    static void dataInjectionTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean(Student.class);
        System.out.println("student id:"+student.getId());
        System.out.println("student hobbies:"+student.getHobbies());
    }
    static void propertyInjectionTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConstructerInjectionUserService service=
            (ConstructerInjectionUserService)context.getBean(ConstructerInjectionUserService.class);
        User user = new User();
        user.setAge(12);
        user.setName("张三");
        service.saveUser(user);
    }
}
