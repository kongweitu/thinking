package com.boot.thinking.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.thinking.entity.Employee;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void redisTest() {
        Employee employee = new Employee();
        employee.setSalary(12223);
        employee.setName("kong");
        employee.setOffice("kongshuzhou");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("zizi","ddd");
        redisTemplate.opsForValue().set("zha",employee);
        Employee res =(Employee) redisTemplate.opsForValue().get("zha");
        System.out.println(res);
    }
}
