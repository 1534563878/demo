package com.zyq.demo.java.jichu;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackTest {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackTest() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    //入栈
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    //出栈
    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        return elements[--size];
    }

    //确保栈数组容量
    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        StackTest stackTest =new StackTest();
    }
}
