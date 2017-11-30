package com.magicsoft.daybyday.factory.simple.normal;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Polo.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:00
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Polo.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Polo extends ShangHaiVolkswagen {//上海大众的具体实现类
    public static final int ID = 1;
    @Override
    public void drive() {
        System.out.println("polo start test");
    }

    @Override
    public String getName() {
        return "polo";
    }
}
