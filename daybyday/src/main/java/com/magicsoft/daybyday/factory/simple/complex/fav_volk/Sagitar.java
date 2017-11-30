package com.magicsoft.daybyday.factory.simple.complex.fav_volk;


import com.magicsoft.daybyday.factory.simple.complex.volk.FAWVolkswagen;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Sagitar.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:02
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Sagitar.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Sagitar extends FAWVolkswagen {
    public static final int ID = 2;
    @Override
    public void drive() {
        System.out.println("sagitar");
    }

    @Override
    public String getName() {
        return "sagitar";
    }

    @Override
    public void brake() {
        System.out.println("Sagitar 刹车挺好的，测试通过了");
    }
}
