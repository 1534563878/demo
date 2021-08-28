package com.zyq.demo.java.lizi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class tryWithResource {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Date());
        list.add("张三");
        Object  o =list.get(0);

    }
}
