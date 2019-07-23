package com.boot.thinking.time;

import com.boot.thinking.annotion.ExtendTest2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTest {
    @Test
    public void Mytest(){
        //string转localtime
        String date = "2019-04-07T15:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date,df);
        Date date1 = new Date();
        //System.out.println(date1);
        ExtendTest2 extendTest2 = new ExtendTest2();
        System.out.println(LocalDateTime.now());

    }
    @Test
    public void listToSet(){
        List list = new ArrayList();
        list.add("kong");
        list.add("kong");
        list.add("kong");
        list.add("kong");
        list.add("wei");
        list.add("tu");
        System.out.println(list);
        System.out.println(new ArrayList<>(new LinkedHashSet<>(list)));
    }
}
