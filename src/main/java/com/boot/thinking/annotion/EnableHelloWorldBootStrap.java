package com.boot.thinking.annotion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootStrap{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldBootStrap.class);
        context.refresh();
        String helloWorld = context.getBean("helloworld",String.class);
        System.out.println("++++++:"+helloWorld);
        context.close();
    }
}
