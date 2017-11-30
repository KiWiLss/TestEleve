package com.magicsoft.daybyday.factory.simple;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Possa.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:43
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Possa.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Possa implements Volkswagen {//具体的产品一
    public static final int ID = 1;
    @Override
    public void diver() {
        System.out.println("possa test");
    }

    @Override
    public String getName() {
        return "possa";
    }
}
