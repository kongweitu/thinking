package com.boot.thinking.time;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.thinking.annotion.ExtendTest2;
import com.boot.thinking.annotion.User;
import com.boot.thinking.entity.Employee;
import com.boot.thinking.entity.LdmContent;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.jaxen.XPath;
import org.jaxen.dom4j.Dom4jXPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import sun.applet.AppletClassLoader;

import java.io.Reader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class TimeTest {
    @Test
    public void timeTest() {

        //string转localtime
        String date = "2019-09-07:20:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, df);
        //字符串转时间戳
        long time = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("============"+ new Date());
        LdmContent ldmContent=new LdmContent();
        //时间戳转字符串
        long time1 = 1554638400000l;
        String instantToString = df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.systemDefault()));
        System.out.println(instantToString);
        //获取当天的0点和24点
        LocalDateTime zero = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime hold = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(hold);
        //locldateTime转字符串
        String zero1 = df.format(zero);
        System.out.println(zero1);
        //获取某个时间点的时间
        LocalDateTime time2 = LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 00, 03));
        LocalDateTime time3 = time2.plusDays(1);
        LocalDateTime time4 = time3.minusDays(2);
        System.out.println(time4);
        //求时间差 Duration
        long time5 = Duration.between(time4, time2).toMillis();
        System.out.println(Duration.between(time4, time2).toMillis());
        //localDateTime转DateTime
        Date date1 = new Date();
        LocalDateTime localDateTime9 = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());
        System.out.println("DATE:"+localDateTime9);
        //timestrap转localdatetime
        Timestamp time0 = Timestamp.from(Instant.now());
        LocalDateTime timestrapTOloaclDateTime = time0.toLocalDateTime();
        //localdatTime转化为timesatrp
        Instant instant0 = LocalDateTime.now().toInstant(ZoneOffset.of("+8"));
        Timestamp timestamp = Timestamp.from(instant0);
        System.out.println(timestamp);
        System.out.println(new Date());
    }

    @Test
    public void loaderTest() throws Exception {
         List<Employee> employeeList = Lists.newArrayList();
        employeeList.add(Employee.builder().name("Matt").salary(5000).office("New York").build());
        employeeList.add(Employee.builder().name("Steve").salary(6000).office("London").build());
        employeeList.add(Employee.builder().name("Carrie").salary(20000).office("New York").build());
        employeeList.add(Employee.builder().name("Peter").salary(7000).office("New York").build());
        employeeList.add(Employee.builder().name("Pat").salary(8000).office("London").build());
        employeeList.add(Employee.builder().name("Tammy").salary(29000).office("Shanghai").build());
        for (int i=0;i<employeeList.size();i++){
            Employee employee =employeeList.get(i);
            Integer salary = employee.getSalary();
            if (salary>8000){
                break;
            }
            String name = employee.getName();
            System.out.println(name+"薪资："+salary);
        }


    }
}







