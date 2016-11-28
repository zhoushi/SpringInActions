package com.domain;

/**
 * Created by Administrator on 2016/11/24.
 */
public class Demo implements java.io.Serializable{

    private String name;
    private Integer age;

    public Demo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Demo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
