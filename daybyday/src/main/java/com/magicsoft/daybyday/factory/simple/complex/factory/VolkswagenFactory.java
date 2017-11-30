package com.magicsoft.daybyday.factory.simple.complex.factory;

import com.magicsoft.daybyday.factory.simple.complex.insurance.Insurance;
import com.magicsoft.daybyday.factory.simple.complex.volk.Volkswagen;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: VolkswagenFactory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:25
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create VolkswagenFactory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public abstract class VolkswagenFactory {

    public abstract Volkswagen createVolkswagen(int productID);

    public abstract Insurance bindInsurance();

    public final Volkswagen createVolkswagen(Class <? extends Volkswagen> clazz){
        Volkswagen volkswagen = null;
        try {
            volkswagen = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return volkswagen;
    };
}
