package com.magicsoft.testeleve.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;

import com.magicsoft.testeleve.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: Utils.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 11:36
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create Utils.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Utils {

    /**
     * 判断是否存在快捷方式
     * */
    public static boolean hasShortcut(Activity activity, String shortcutName) {
        String url = "";
        int systemversion = Integer.parseInt(android.os.Build.VERSION.SDK);
        Log.d("testActivity", "systemversion   "+systemversion);
/* 大于8的时候在com.android.launcher2.settings 里查询（未测试） */
        if (systemversion < 8) {
            url = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            url = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        ContentResolver resolver = activity.getContentResolver();
        Cursor cursor = resolver.query(Uri.parse(url), null, "title=?",
                new String[] { shortcutName }, null);
        Log.d("testActivity", "cursor   "+cursor);
        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }


    /**
     * 创建快捷方式
     * title: 快捷方式的标题
     * intentContent：点击快捷方式时，向目标Activity发送的意图中附带的内容
     * cls: 快捷方式目标类
     * action：设置快捷方式目标的action，这个东西主要是在删除该快捷方式的时候用到，用来指定删除的快捷方式，一定要相同，如果不同无法删除
     * */
    public static void createShortCut(Context context,String title, String intentContent, Class cls, String action){
// 创建添加快捷方式的intent
        Intent addIntent = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
// 允许重复创建
        addIntent.putExtra("duplicate", true);//这个设置没有什么用，就算这只成了允许重复创建，依然不能重复创建
// 加载快捷方式图标
        Parcelable icon = Intent.ShortcutIconResource.fromContext(context,
                R.mipmap.icon_two);
// 创建点击快捷方式后启动的程序，这里启动TestActivity1
        Intent purposeIntent = new Intent(context,
                cls);
        purposeIntent.putExtra("intentContent", intentContent);
//设置action，这个action主要是在删除该快捷方式的时候用的上，删除快捷方式时意图action一定要和这个一样否则无法删除
        purposeIntent.setAction(action);
// 设置快捷方式的标题
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
// 设置快捷方式的图标
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
// 设置快捷方式点击时对应的Intent
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, purposeIntent);
// 发送广播，添加快捷方式
        context.sendBroadcast(addIntent);
    }
}
