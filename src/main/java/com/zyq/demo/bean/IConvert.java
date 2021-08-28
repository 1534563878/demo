package com.zyq.demo.bean;

@FunctionalInterface
public interface IConvert<F, T> {
    T convert(F form);
}