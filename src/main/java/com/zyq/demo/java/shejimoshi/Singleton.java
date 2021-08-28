package com.zyq.demo.java.shejimoshi;

//单例模式
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        //双重检索
        if (singleton == null) {
            //加锁保证线程安全
            synchronized (Singleton.class) {
                //双重检索
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
