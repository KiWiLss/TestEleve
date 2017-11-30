package com.magicsoft.daybyday.factory.simple;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: TestMain.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:47
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create TestMain.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class TestMain {
    public static void main(String[] args) {
        Possa possa = new Possa();

        Polo polo = new Polo();

        SHVolkFractory shVolkFractory = new SHVolkFractory();

        Volkswagen volk1 = shVolkFractory.createVolk(Possa.ID);
        volk1.diver();

        Volkswagen volk2 = shVolkFractory.createVolk(Polo.ID);
        volk2.diver();

         shVolkFractory.createVolkswagen(possa.getClass()).diver();//利用反射做到
    }

}
