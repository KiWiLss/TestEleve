package com.magicsoft.daybyday.factory.simple.normal;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: FAWVolkswagenFactory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:05
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create FAWVolkswagenFactory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class FAWVolkswagenFactory extends VolkFactory {//生产一汽的工厂
    @Override
    public Volkswagen createVolkswagen(int productID) {
        Volkswagen volkswagen=null;
        switch (productID) {
            case Sagitar.ID:
                volkswagen=new Sagitar();
                break;
            case Magotan.ID:
                volkswagen=new Magotan();
                break;
        }
        return volkswagen;
    }
}
