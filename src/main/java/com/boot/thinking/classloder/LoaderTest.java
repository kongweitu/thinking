package com.boot.thinking.classloder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLClassLoader;
@RestController
public class LoaderTest {
    @RequestMapping("mytest")
    public String test(){
        return "ldm";
    }


}
