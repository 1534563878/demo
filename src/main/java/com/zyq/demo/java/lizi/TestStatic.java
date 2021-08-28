package com.zyq.demo.java.lizi;

public class TestStatic {
    public static void main(String[] args) {
        //静态工厂
        Person1.newPerson(1,"张三");
    }
}
class Person1 {
    Integer age ;
    String name;
    public static Person1 newPerson(int age , String name){
        Person1 person = new Person1();
        person.age=age;
        person.name=name;
        return person;
    }
    public static Person1 newAge(int age , String name){
        Person1 person1 = new Person1();
        person1.age=age;
        return person1;
    }
    public static Person1 newName(int age , String name){
        Person1 person = new Person1();
        person.name=name;
        return person;
    }
}
class Person2 extends Person1 {

    public static Person1 newPerson(int age , String name){
        Person1 person = new Person1();
        person.age=age;
        person.name=name;
        return person;
    }
}
