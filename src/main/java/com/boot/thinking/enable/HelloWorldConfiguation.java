package com.boot.thinking.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguation {
    @Bean
    public String helloWorld(){
        return "hello world";
    }
}
