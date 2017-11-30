package com.magicsoft.testeleve.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.magicsoft.testeleve.R;
import com.magicsoft.testeleve.activity.TextActivity;

public class ShortCutSample {

    public static void createShortCut(Context contxt) {
        //String applicationName=getApplicationName(contxt);
        //String applicationName = UIUtils.getString(R.string.app_name);//程序名称，不是packageName
        String applicationName=getApplicationName(contxt);
        if (isInstallShortcut(contxt,applicationName)) {// 如果已经创建了一次就不会再创建了
            return;
        }
        Log.e("MMM", "createShortCut: "+applicationName );
        Intent sIntent = new Intent(Intent.ACTION_MAIN);
        sIntent.addCategory(Intent.CATEGORY_LAUNCHER);// 加入action,和category之后，程序卸载的时候才会主动将该快捷方式也卸载
        sIntent.setClass(contxt, TextActivity.class);//点击后进入的Activity

        Intent installer = new Intent();
        installer.putExtra("duplicate", false);//false标示不重复创建
        installer.putExtra("android.intent.extra.shortcut.INTENT", sIntent);
        //设置应用的名称
        installer.putExtra("android.intent.extra.shortcut.NAME", "新的快捷键");
        //设置图标
        installer.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contxt, R.mipmap.icon_one));
        installer.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        contxt.sendBroadcast(installer);//发送安装桌面图标的通知
    }

    //获取当前app的应用程序名称
    public static String getApplicationName(Context  context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo=packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =(String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }
    public static boolean isInstallShortcut(Context context,String applicationName) {
        boolean isInstallShortcut = false;
        ContentResolver cr = context.getContentResolver();
        //sdk大于8的时候,launcher2的设置查找
        String AUTHORITY = "com.android.launcher2.settings";
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
        Cursor c = cr.query(CONTENT_URI, new String[] { "title", "iconResource" },
                "title=?", new String[] { applicationName }, null);
        if (c != null && c.getCount() > 0) {
            isInstallShortcut = true;
        }
        if (c != null) {
            c.close();
        }
        //如果存在先关闭cursor，再返回结果
        if (isInstallShortcut) {
            return isInstallShortcut;
        }
        //android.os.Build.VERSION.SDK_INT < 8时
        AUTHORITY = "com.android.launcher.settings";
        CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
        c = cr.query(CONTENT_URI, new String[] { "title", "iconResource" }, "title=?",
                new String[] {applicationName}, null);
        if (c != null && c.getCount() > 0) {
            isInstallShortcut = true;
        }
        if (c != null) {
            c.close();
        }
        return isInstallShortcut;
    }
}  