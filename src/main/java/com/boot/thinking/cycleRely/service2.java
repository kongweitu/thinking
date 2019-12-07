package com.boot.thinking.cycleRely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class service2 {
    @Autowired
    @Lazy
    private service1 service11;
    public String test(){
        String result = service11.test();
        return result;
    }

}
