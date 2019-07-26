package com.boot.thinking.time;

import com.boot.thinking.annotion.ExtendTest2;
import com.boot.thinking.annotion.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.applet.AppletClassLoader;

import java.net.URL;
import java.net.URLClassLoader;
import java.time.*;
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
        String date = "2019-04-07T20:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date,df);
        //字符串转时间戳
        long time = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(time);
        //时间戳转字符串
        long time1 = 1554638400000l;
        String instantToString =df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.systemDefault()));
        System.out.println(instantToString);
        //获取当天的0点和24点
        LocalDateTime zero = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        LocalDateTime hold = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        System.out.println(hold);
        //locldateTime转字符串
        String zero1 = df.format(zero);
        System.out.println(zero1);
        //获取某个时间点的时间
        LocalDateTime  time2 = LocalDateTime.of(LocalDate.now(),LocalTime.of(18,00,03));
        LocalDateTime   time3 = time2.plusDays(1);
        LocalDateTime   time4 = time3.minusDays(2);
        System.out.println(time4);
        //求时间差 Duration
        long time5 = Duration.between(time4,time2).toMillis();
        System.out.println(Duration.between(time4,time2).toMillis());
        //localDateTime转DateTime
        Date date1 = new Date();
        LocalDateTime localDateTime9 = LocalDateTime.ofInstant(date1.toInstant(),ZoneId.systemDefault());
        System.out.println(localDateTime9);
    }
    @Test
    public void loaderTest(){
        //1. bootstrap class loader： null，拿不到 BootStrap 的名字
        System.out.println(String.class.getClassLoader());

    //2. extesion class loader 负责扩展包中的类(jre/lib/ext下面的类) sun.misc.Launcher$ExtClassLoader
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());

    //3. application class loader 负责自己写的类，也称为系统 classLoader。sun.misc.Launcher$AppClassLoader
        System.out.println(User.class.getClassLoader().getClass().getName());

    // sun.misc.Launcher$AppClassLoader@14dad5dc
        System.out.println(ClassLoader.getSystemClassLoader());
    // sun.misc.Launcher$AppClassLoader@19821f
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

    // sun.misc.Launcher$AppClassLoader@14dad5dc
        System.out.println(User.class.getClassLoader());
    // sun.misc.Launcher$AppClassLoader
        System.out.println(User.class.getClassLoader().getClass().getName());
    }



}
