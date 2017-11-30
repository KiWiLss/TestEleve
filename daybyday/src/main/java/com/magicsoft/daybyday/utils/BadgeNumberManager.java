package com.magicsoft.daybyday.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

public class BadgeNumberManager {

    private Context mContext;

    private BadgeNumberManager(Context context) {
        mContext = context;
    }

    public static BadgeNumberManager from(Context context) {
        return new BadgeNumberManager(context);
    }

    private static BadgeNumberManager.Impl IMPL;

    /**
     * 设置应用在桌面上显示的角标数字
     * @param number 显示的数字
     */
    public void setBadgeNumber(int number) {
        IMPL.setBadgeNumber(mContext, number);
    }

    interface Impl {

        void setBadgeNumber(Context context, int number);

    }

    static class ImplHuaWei implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            BadgeNumberManagerHuaWei.setBadgeNumber(context, number);
        }
    }

    static class ImplVIVO implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            BadgeNumberManagerVIVO.setBadgeNumber(context, number);
        }
    }
    static class ImplXiaoMi implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            //Utils.setBadgeNumber(,number);
        }
    }

    static class ImplBase implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            //do nothing
        }
    }

    static {
        String manufacturer = Build.MANUFACTURER;
        Log.e("MMM", "static initializer: "+manufacturer );
        if (manufacturer.equalsIgnoreCase("HUAWEI")) {
            IMPL = new ImplHuaWei();
        } else if (manufacturer.equalsIgnoreCase("vivo")) {
            IMPL = new ImplVIVO();
        } else if (manufacturer.equalsIgnoreCase("Xiaomi")) {
            //其他品牌机型的实现类
            //IMPL = new ImplXXX();

        } else {
            IMPL = new ImplBase();
        }
    }
}

