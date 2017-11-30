package com.magicsoft.daybyday.factory.simple.normal;

import static android.R.attr.id;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ShangHaiVolkswagenFactory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:04
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create ShangHaiVolkswagenFactory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ShangHaiVolkswagenFactory extends VolkFactory {//生产上海大众的工厂
    @Override
    public Volkswagen createVolkswagen(int productID) {
        ShangHaiVolkswagen volkswagen = null;
        switch(productID){
            case Passat.ID:
                volkswagen = new Passat();
                break;
            case Polo.ID:
                volkswagen = new Polo();
                break;
            default:
                volkswagen = null;
        }
        return volkswagen;
    }
}
