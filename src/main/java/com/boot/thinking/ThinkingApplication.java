package com.boot.thinking;

import com.boot.thinking.annotion.ExtendTest2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class ThinkingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ThinkingApplication.class, args);
    }

}
