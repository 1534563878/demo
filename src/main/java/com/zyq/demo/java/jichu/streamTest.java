package com.zyq.demo.java.jichu;

import lombok.Data;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900,18, "male", "New York"));
        personList.add(new Person("Jack", 7000,19,"male", "Washington"));
        personList.add(new Person("Lily", 7800,20,"female", "Washington"));
        personList.add(new Person("Anni", 8200,21,"female", "New York"));
        personList.add(new Person("Owen", 9500,22,"male", "New York"));
        personList.add(new Person("Alisa", 7900,23,"female", "New York"));



/*        List<String> list = personList.stream()
                .filter(person -> person.getSalary() > 8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            person.setSalary(person.getSalary()+10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println(personListNew);
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strList);*/
        Optional<Person> emptyOpt = Optional.empty();
        //emptyOpt.get();
      //  Map<String, Person> collect = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
       /* System.out.println(personList);
        System.out.println(collect);*/
      /*  Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect1);
        Map<String, Long> collect2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting()));
        System.out.println(collect2);*/
        //纽约工资最高的，华盛顿工资最高的
      /*  Map<String, Optional<Person>> collect3 = personList.stream().collect(Collectors.groupingBy(Person::getArea, Collectors.maxBy(Comparator.comparing(Person::getSalary))));
        System.out.println(collect3);
        //男的性别的总和和女的性比的总和
        Map<String, Integer> collect2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.summingInt(Person::getAge)));
        System.out.println(collect2);*/

    }
}
@Data
class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}
