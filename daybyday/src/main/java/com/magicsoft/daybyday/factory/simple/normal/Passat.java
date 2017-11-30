package com.magicsoft.daybyday.factory.simple.normal;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Passat.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:58
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Passat.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Passat extends ShangHaiVolkswagen {//上海大众的具体实现类
    public static final int ID = 0;
    @Override
    public void drive() {
        System.out.println("passat start test");
    }

    @Override
    public String getName() {
        return "passat";
    }
}
