package com.magicsoft.daybyday.factory.simple.complex.client;

import com.magicsoft.daybyday.factory.simple.complex.factory.FAWVolkswagenFactory;
import com.magicsoft.daybyday.factory.simple.complex.factory.ShangHaiVolkswagenFactory;
import com.magicsoft.daybyday.factory.simple.complex.fav_volk.Magotan;
import com.magicsoft.daybyday.factory.simple.complex.fav_volk.Sagitar;
import com.magicsoft.daybyday.factory.simple.complex.insurance.Insurance;
import com.magicsoft.daybyday.factory.simple.complex.shanghai_volk.Polo;
import com.magicsoft.daybyday.factory.simple.complex.shanghai_volk.Possa;
import com.magicsoft.daybyday.factory.simple.complex.volk.FAWVolkswagen;
import com.magicsoft.daybyday.factory.simple.complex.volk.Volkswagen;


/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Client.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 15:21
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
        Volkswagen passat = factory.createVolkswagen(Possa.ID);
        passat.drive();

        Volkswagen polo = factory.createVolkswagen(Polo.ID);
        polo.drive();
        Insurance shanghaiInsurance = factory.bindInsurance();
        System.out.println(shanghaiInsurance.getName());

        System.out.println("开始测试一汽大众的车辆");
        FAWVolkswagenFactory fawFactory = new FAWVolkswagenFactory();

        FAWVolkswagen magotan = (FAWVolkswagen)fawFactory.createVolkswagen(Magotan.ID);
        magotan.drive();
        magotan.brake();
        FAWVolkswagen sagitar = fawFactory.createVolkswagen(Sagitar.ID);
        sagitar.drive();
        sagitar.brake();
        Insurance fawInsurance = fawFactory.bindInsurance();
        System.out.println(fawInsurance.getName());
    }
}
