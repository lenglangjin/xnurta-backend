package com.leda.test;


import java.util.Arrays;

public class MyArrayList<T> {

    private Object[] data = new Object[8];

    private int index = 0;

    private int size = 0;

    public MyArrayList() {}

    public MyArrayList(int size) {
        this.size = size;
    }

    public void add(Object val) {
        if (index > 0.75 * size) {
            size = (int) (size * 1.5);
            data = Arrays.copyOf(data, size);
        }
        data[index++] = val;
    }

}














