package com.boot.thinking.time;

import com.boot.thinking.entity.Employee;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.spring5.processor.SpringOptionInSelectFieldTagProcessor;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    public static List<Employee> employeeList = Lists.newArrayList();

    static{
        employeeList.add(Employee.builder().name("kong").salary(5000).office("New York").build());
        employeeList.add(Employee.builder().name("Steve").salary(6000).office("London").build());
        employeeList.add(Employee.builder().name("Carrie").salary(20000).office("New York").build());
        employeeList.add(Employee.builder().name("Peter").salary(7000).office("New York").build());
        employeeList.add(Employee.builder().name("Pat").salary(8000).office("London").build());
        employeeList.add(Employee.builder().name("tang").salary(29000).office("Shanghai").build());
    }
    @Test
    public void test(){

      /*  //常规做法
        Eate eate = new EateImp();
        eate.eat();
        //内部类做法
        Eate eate1 = new Eate() {
            @Override
            public void eat() {
                System.out.println("eat orange");
            }
        };
        //lambda表达式
        Eate eate2 = ()-> System.out.println("eat bunana");
        eate2.eat();
        //遍历list
        List list = new ArrayList();
        list.add("kong");
        list.add("wei");
        list.add("tu");
        list.add("kong");
        //list.forEach((e)-> System.out.println(e));
        list.forEach((x)->{if("tu".equals(x)) {
            System.out.println(x);
        }
        //过滤操作
        });
        list.stream().filter(s->s.equals("wei")).forEach(c1-> System.out.println(c1));
        //遍历map
        Map map = new HashMap<>();
        map.put("A",20);
        map.put("B",30);
        map.put("C",40);
        map.put("D",50);
        map.forEach((key,value)-> System.out.println("key:"+key+"value:"+value));*/
       //条件查询
        Boolean ismatch = employeeList.stream().anyMatch((employee)-> employee.getOffice().contains("London"));
        System.out.println(ismatch);
        //选出办公地点是new york的员工
        List<Employee> allMatchedEmployees = employeeList.stream().filter(employee -> employee.getOffice().equals("New York")).collect(Collectors.toList());
        System.out.println(allMatchedEmployees);
        //找出工资最高的员工
        Optional<Employee> employee = employeeList.stream().max((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(employee);
        //找出工资最少的员工
        Optional<Employee> employee1 = employeeList.stream().min((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(employee1);
        //返回姓名列表
        List<String> list = employeeList.stream().map((employee2 -> employee2.getName())).collect(Collectors.toList());
        System.out.println(list);
        //List转化Map
        Map<String,Employee>  listToMap = employeeList.stream().collect(Collectors.toMap((key)->key.getName(),value->value));
        System.out.println(listToMap);
        //统计办公室是New York的个数
        long count =employeeList.stream().filter((employee3)->employee3.getOffice().equals("New York")).count();
        System.out.println(count);
        //List转换为Set
        Set<Employee> listToSet =employeeList.stream().collect(Collectors.toSet());
        System.out.println(listToSet);
        //查找办公室地点是New York的员工
        List<Employee> employees = employeeList.stream().filter(employee2 -> employee2.getOffice().equals("New York")).collect(Collectors.toList());
        System.out.println(employees);
        //按照工资的降序来列出员工信息
        List<Employee> sortEmployees = employeeList.stream().sorted((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary())).collect(Collectors.toList());
        System.out.println(sortEmployees);
        //按照名字的升序列出员工信息
        List<Employee> sortEmployeesName = employeeList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println(sortEmployeesName);
        //







    }
    interface  Eate{
       public void eat();
    }
    class  EateImp implements Eate{

        @Override
        public void eat() {
            System.out.println("eate apple");
        }
    }
}
