package com.magicsoft.testeleve;

import android.app.Application;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: MyApp.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 10:58
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create MyApp.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MyApp extends Application {

    private MyFloatWindow myFloatWindow;

    @Override
    public void onCreate() {
        super.onCreate();
//        myFloatWindow = new MyFloatWindow(this);
//        registerActivityLifecycleCallbacks(myFloatWindow);
    }

    public MyFloatWindow getMyFloatWindow() {
        return myFloatWindow;
    }
}
