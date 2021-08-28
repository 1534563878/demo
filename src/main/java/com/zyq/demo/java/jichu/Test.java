package com.zyq.demo.java.jichu;

import java.util.*;
//枚举类
public class Test {
    public static void main(String[] args) {
        Day[] day = Day.values();
        System.out.println(Arrays.toString(day));
        Enum e = Day.MONDAY;
        Class<?> clazz = e.getDeclaringClass();
        if (clazz.isEnum()) {
            //返回该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
            Day[] dsz = (Day[]) clazz.getEnumConstants();
            System.out.println("dsz:" + Arrays.toString(dsz));
        }
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Day2 {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String desc;

    Day2(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (Day2 day : Day2.values()) {
            System.out.println("name:" + day.name() +
                    ",desc:" + day.getDesc());
        }
    }
}

class test2 {
    public static void main(String[] args) {
        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
        /*System.out.println(names2.stream().sorted().collect(Collectors.toList()));*/
        System.out.println(names2);
        Collections.sort(names2,(s1, s2)-> s1.compareTo(s2));
        System.out.println(names2);
    }
}
