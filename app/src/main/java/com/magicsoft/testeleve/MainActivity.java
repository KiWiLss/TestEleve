package com.magicsoft.testeleve;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.magicsoft.testeleve.activity.ShortCutActivity;
import com.magicsoft.testeleve.activity.SuspendActivity;
import com.magicsoft.testeleve.activity.TextActivity;

public class MainActivity extends AppCompatActivity {

    private ComponentName mDefault;
    private ComponentName mDefault11;
    private ComponentName mDefault12;
    private PackageManager mPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDefault = getComponentName();

        mDefault11 = new ComponentName(getBaseContext(), "com.magicsoft.testeleve.Test11");
        mDefault12 = new ComponentName(getBaseContext(), "com.magicsoft.testeleve.Test12");

        mPm = getApplicationContext().getPackageManager();

        Log.e("MMM", "onCreate: "+hasShortcut(this));
    }

    public void eleve(View view) {


        PackageManager pm = getApplicationContext().getPackageManager();
        //去除旧图标，不去除的话会出现2个App图标
        pm.setComponentEnabledSetting(getComponentName(),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

        //显示新图标
        pm.setComponentEnabledSetting(new ComponentName(
                        getBaseContext(),
                        "com.magicsoft.testeleve.Test11"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
//        disableComponent(mDefault);
//        disableComponent(mDefault12);
//        enableComponent(mDefault11);
    }

    private void enableComponent(ComponentName mDefault11) {
        mPm.setComponentEnabledSetting(mDefault,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
        );

    }

    private void disableComponent(ComponentName mDefault) {

        mPm.setComponentEnabledSetting(mDefault,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
                );
    }

    public void twelev(View view) {
        PackageManager pm = getApplicationContext().getPackageManager();
        pm.setComponentEnabledSetting(mDefault,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        //去除旧图标，不去除的话会出现2个App图标
        pm.setComponentEnabledSetting(mDefault11,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

        //显示新图标
        pm.setComponentEnabledSetting(new ComponentName(
                        getBaseContext(),
                        "com.magicsoft.testeleve.Test12"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

        //disableComponent(mDefault);
//        disableComponent(mDefault11);
//        enableComponent(mDefault12);
    }

    public void textClick(View view) {
        startActivity(new Intent(this, TextActivity.class));
    }

    public void suspendClick(View view) {
        startActivity(new Intent(this, SuspendActivity.class));
    }

    public void shortcutClick(View view) {
        startActivity(new Intent(this, ShortCutActivity.class));
    }

    public static final String ACTION_ADD_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";

    public void createShortCut(){
//创建快捷方式的Intent
        Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        //不允许重复创建
        shortcutintent.putExtra("duplicate", false);
        //需要现实的名称
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "创建");
        //快捷图片
        Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.icon_one);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        //点击快捷图片，运行的程序主入口
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(getApplicationContext() , ShortCutActivity.class));
        //发送广播。OK
        sendBroadcast(shortcutintent);
    }


    /**
     * 创建快捷方式
     * title: 快捷方式的标题
     * intentContent：点击快捷方式时，向目标Activity发送的意图中附带的内容
     * cls: 快捷方式目标类
     * action：设置快捷方式目标的action，这个东西主要是在删除该快捷方式的时候用到，用来指定删除的快捷方式，一定要相同，如果不同无法删除
     * */
    public void createShortCut(String title, String intentContent, Class cls, String action){
// 创建添加快捷方式的intent
        Intent addIntent = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
// 允许重复创建
        addIntent.putExtra("duplicate", true);//这个设置没有什么用，就算这只成了允许重复创建，依然不能重复创建
// 加载快捷方式图标
        Parcelable icon = Intent.ShortcutIconResource.fromContext(this,
                R.mipmap.icon_two);
// 创建点击快捷方式后启动的程序，这里启动TestActivity1
        Intent purposeIntent = new Intent(this,
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
        sendBroadcast(addIntent);
    }


    public void createClick(View view) {
        createShortCut("新快捷键","values",ShortCutActivity.class,"android.intent.action.CREATE_SHORTCUT");
        //createShortCut();
    }

    public void createClick2(View view) {
        delShortcut(this);
    }
    /**
     * 删除当前应用的桌面快捷方式
     */
    public static void delShortcut(Context cx) {
        Intent shortcut = new Intent(
                "com.android.launcher.action.UNINSTALL_SHORTCUT");

        // 获取当前应用名称
        String title = null;
        try {
            final PackageManager pm = cx.getPackageManager();
            title = pm.getApplicationLabel(
                    pm.getApplicationInfo(cx.getPackageName(),
                            PackageManager.GET_META_DATA)).toString();
        } catch (Exception e) {
        }
        // 快捷方式名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
        Log.e("MMM", "delShortcut: "+title);
        Intent shortcutIntent = cx.getPackageManager()
                .getLaunchIntentForPackage(cx.getPackageName());
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        cx.sendBroadcast(shortcut);
    }

    /**
     * 判断桌面是否已添加快捷方式
     *
     */
    public static boolean hasShortcut(Context cx) {
        boolean result = false;
        // 获取当前应用名称
        String title = null;
        try {
            final PackageManager pm = cx.getPackageManager();
            title = pm.getApplicationLabel(
                    pm.getApplicationInfo(cx.getPackageName(),
                            PackageManager.GET_META_DATA)).toString();
        } catch (Exception e) {
        }

        final String uriStr;
        if (android.os.Build.VERSION.SDK_INT < 8) {
            uriStr = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            uriStr = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        final Uri CONTENT_URI = Uri.parse(uriStr);
        final Cursor c = cx.getContentResolver().query(CONTENT_URI, null,
                "title=?", new String[] { title }, null);
        if (c != null && c.getCount() > 0) {
            result = true;
        }
        return result;
    }
}
