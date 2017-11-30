package com.magicsoft.daybyday.factory.simple.normal;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: VolkFactory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:55
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create VolkFactory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public abstract class VolkFactory  {//抽象的工厂类

    public abstract Volkswagen createVolkswagen(int productID);

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
