package com.magicsoft.daybyday.factory.simple;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: SHVolkFractory.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:45
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create SHVolkFractory.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class SHVolkFractory {//工厂类

    public Volkswagen createVolk(int id){
        Volkswagen volkswagen = null;
        switch(id){
            case Possa.ID:
                volkswagen = new Possa();
                break;
            case Polo.ID:
                volkswagen = new Polo();
                break;
            default:
                volkswagen = null;
        }
        return volkswagen;
    }
    //利用反射,直接生产对应的产品
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
