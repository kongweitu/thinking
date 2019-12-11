package com.boot.thinking.kafak;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Produce {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public void send(@RequestBody String request){
        JSONObject jsonObject = new JSONObject();
        kafkaTemplate.send("test", JSON.toJSONString(request));
    }
}
