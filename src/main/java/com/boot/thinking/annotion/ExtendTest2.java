package com.boot.thinking.annotion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ExtendTest2 {
    @Resource
    private ExtendTest extendTest;
    @RequestMapping(value = "KONG",method = RequestMethod.POST)
    public String extendTest(@RequestBody String request){
        JSONObject jsonObject = JSONObject.parseObject(request);
        LdmContent ldmContent = JSON.toJavaObject(jsonObject,LdmContent.class);
        return JSON.toJSONString(ldmContent);
    }
}
