package com.boot.thinking.cycleRely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CycleRely {
    @Autowired
    @Lazy
    private service2 service22;
    @RequestMapping("test")
    public String test(){
        String result = service22.test();
        return result;
    }



}
