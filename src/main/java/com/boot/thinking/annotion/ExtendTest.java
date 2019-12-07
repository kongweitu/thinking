package com.boot.thinking.annotion;

import com.boot.thinking.entity.Employee;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class ExtendTest extends HelloWorldConfiguration{

    public  void extend(){
        System.out.println("this is a extend");
    }


}
