package com.zyq.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        Employee e6 = new Employee(1l, 19, "M", "David", "Feezor");
        Employee e7 = new Employee(2l, 29, "F", "Melissa", "Roy");
        Employee e8 = new Employee(3l, 19, "M", "Alex", "Gussin");
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(Arrays.asList(new Employee[] {  e6, e7, e8 }));
        //  ==  1.输出符合表达式的每一个对象
       /* list.stream().filter(employee -> employee.getAge()>21).forEach(System.out::println);
        list.stream().filter(p -> p.getAge() > 21).forEach(System.out::println);*/
        /* 返回年龄大于21的第一个人 System.out.println(list.stream().filter(p -> p.getAge() > 21).findFirst());*/
        //获取e2的信息
        //list.stream().filter(Predicate.isEqual(e2)).collect(Collectors.<Employee>toList()).forEach(System.out::println);
//返回一个集合
       /* System.out.println(list.stream().map(Employee::getId).collect(Collectors.toList()));
        System.out.println(Employee.builder().build());*/
     /*   List<Employee> collect = list.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
              *//*  .sorted(Comparator.comparing(Employee::getId).reversed())*//*
                .collect(Collectors.toList());
        System.out.println(collect);
        List<Employee> collect1 = list.stream().peek(Employee::getAge).collect(Collectors.toList());
        System.out.println(collect1+"collect1");*/

        for (Employee employeelist: list) {
            //    提示用户要注意该对象有可能为null
            //    简化if else代码
            Optional<Employee> employeelist1 = Optional.of(employeelist);
            Integer score = employeelist1.filter(s -> s.getId() >= 1).map(Employee::getAge).orElse(0);
            if (score > 19) {
                System.out.println("入选：" + employeelist.getFirstName());
            }
        }
    }
}
@Data
@Builder
@AllArgsConstructor
@ToString
class Employee {
    private Long id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

}

