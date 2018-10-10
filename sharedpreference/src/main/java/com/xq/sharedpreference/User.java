package com.xq.sharedpreference;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = -1399975600369162924L;
    private String name;
    private int age;
    private float height;

    public User() {
    }

    public User(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
