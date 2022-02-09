package com.codegym.model;

public class Counter {
    private int count;

    public Counter() {
    }

    public Counter(Integer count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment(){
        return count++;
    }
}
