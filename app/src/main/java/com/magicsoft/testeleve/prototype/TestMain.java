package com.magicsoft.testeleve.prototype;

import java.util.ArrayList;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: TestMain.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 17:47
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create TestMain.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class TestMain {
    public static void main(String[] args) {
        //对对象进行测试
        Person p=new Person();
        p.setAge(18);
        p.setName("张三");
        p.setHeight(178);
        p.setWeight(65);
        System.out.println(p);

        Person p1= null;
        try {
            p1 = (Person) p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(p1);

        p1.setName("李四");
        System.out.println(p);
        System.out.println(p1);

        //带有集合的对象测试
        Person2 p2=new Person2();
        p2.setAge(18);
        p2.setName("张三");
        p2.setHeight(178);
        p2.setWeight(65);
        ArrayList<String> hobbie = new ArrayList<>();
        hobbie.add("hello");
        hobbie.add("kiwi");

        p2.setHobbies(hobbie);
        System.out.println(p);

        try {
            Person2 pClone2 = (Person2) p2.clone();
            System.out.println(pClone2.toString());

            pClone2.getHobbies().add("&&&");

            System.out.println(p2);
            System.out.println(pClone2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
