package com.magicsoft.daybyday.factory.simple.normal;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Client.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:07
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create Client.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Client {
    public static void main(String[] args) {
        System.out.println("开始测试上海大众的车辆");

        ShangHaiVolkswagenFactory factory = new ShangHaiVolkswagenFactory();

        ShangHaiVolkswagen passat = (ShangHaiVolkswagen) factory.createVolkswagen(Passat.ID);
        passat.drive();

        ShangHaiVolkswagen polo = (ShangHaiVolkswagen) factory.createVolkswagen(Polo.ID);
        polo.drive();

        System.out.println("开始测试一汽大众的车辆");
        FAWVolkswagenFactory fawFactory = new FAWVolkswagenFactory();

        FAWVolkswagen magotan = (FAWVolkswagen) fawFactory.createVolkswagen(Magotan.ID);
        magotan.drive();
        magotan.brake();
        FAWVolkswagen sagitar = (FAWVolkswagen) fawFactory.createVolkswagen(Sagitar.ID);
        sagitar.drive();
        sagitar.brake();
    }
}
