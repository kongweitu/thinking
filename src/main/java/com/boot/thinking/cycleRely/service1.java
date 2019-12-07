package com.boot.thinking.cycleRely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class service1 {
    @Autowired
    @Lazy
    private service2 service22;

    public String test(){
        String result = service22.test();
        return result;
    }
}
