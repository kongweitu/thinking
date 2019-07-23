package com.boot.thinking.annotion;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController{
    @Resource
    private UserDao userDao;
    @RequestMapping("11")
    public String test(){
        String name = "kong";
        User user = userDao.queryUserByName(name);
        return JSON.toJSONString(user);
    }
}
