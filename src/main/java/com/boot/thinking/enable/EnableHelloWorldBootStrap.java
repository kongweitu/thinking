package com.boot.thinking.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


@EnableHelloWorld
public class EnableHelloWorldBootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldBootStrap.class);
        context.refresh();
        String hellowrldBean = context.getBean("helloWorld",String.class);
        System.out.println(hellowrldBean);
    }
}
