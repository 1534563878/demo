package com.zyq.demo.java.lizi;


//单例模式的例子
public class Person {
    private Integer age;
    private String name;
    //
    private volatile static Person person;
    //无参构造
    public Person() {
    }
    //静态工厂方法
    public static Person getPerson(){
        //双重检索
        if (person == null) {
            //加锁保证线程安全
            synchronized (Person.class){
                if (person == null) {
                    person= new Person();
                }
            }
        }
        return person;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printlofo(){
        System.out.println("name="+name+"age="+age);
    }
}
class TestSing{
    public static void main(String[] args) {
        Person person = Person.getPerson();
        person.setName("张三");
        person.setAge(1);
        person.printlofo();
    }
}
