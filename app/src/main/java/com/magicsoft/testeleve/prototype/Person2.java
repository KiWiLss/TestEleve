package com.magicsoft.testeleve.prototype;

import java.util.ArrayList;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Person.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 17:41
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create Person.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}带有集合的对象
 */

public class Person2 implements Cloneable{
    private String name;
    private int age;
    private double height;
    private double weight;
    private ArrayList<String> hobbies=new ArrayList<String>();

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
    //1,implement cloneable
    //2,重写clone()方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //完成克隆
        Person2 person=null;

        try {

            person= (Person2) super.clone();
            person.name=this.name;
            person.age=this.age;
            person.height=this.height;
            person.weight=this.weight;
            //对于集合要进行深拷贝
            person.hobbies= (ArrayList<String>) this.hobbies.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return person;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", hobbies=" + hobbies +
                '}';
    }
}
