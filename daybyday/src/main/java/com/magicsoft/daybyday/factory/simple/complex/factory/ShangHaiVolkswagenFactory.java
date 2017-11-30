package com.magicsoft.daybyday.factory.simple.complex.factory;

import com.magicsoft.daybyday.factory.simple.complex.insurance.Insurance;
import com.magicsoft.daybyday.factory.simple.complex.insurance.OneInsurance;
import com.magicsoft.daybyday.factory.simple.complex.shanghai_volk.Polo;
import com.magicsoft.daybyday.factory.simple.complex.shanghai_volk.Possa;
import com.magicsoft.daybyday.factory.simple.complex.volk.ShangHaiVolkswagen;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ShangHaiVolkswagenFactory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:28
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create ShangHaiVolkswagenFactory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ShangHaiVolkswagenFactory extends VolkswagenFactory {
    @Override
    public ShangHaiVolkswagen createVolkswagen(int productID) {
        ShangHaiVolkswagen volkswagen=null;
        switch (productID) {
            case Possa.ID:
                volkswagen= new Possa();
                break;
            case Polo.ID:
                volkswagen=new Polo();
                break;
        }
        return  volkswagen;
    }



    @Override
    public Insurance bindInsurance() {
        return new OneInsurance();
    }
}
