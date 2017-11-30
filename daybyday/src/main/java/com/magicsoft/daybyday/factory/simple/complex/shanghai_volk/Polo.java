package com.magicsoft.daybyday.factory.simple.complex.shanghai_volk;


import com.magicsoft.daybyday.factory.simple.complex.volk.ShangHaiVolkswagen;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Polo.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:44
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Polo.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Polo extends ShangHaiVolkswagen {//具体产品二
    public static final int ID = 2;


    @Override
    public void drive() {
        System.out.println("polo test");
    }

    @Override
    public String getName() {
        return "polo";
    }
}
