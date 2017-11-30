package com.magicsoft.testeleve.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.magicsoft.testeleve.MainActivity;
import com.magicsoft.testeleve.R;
import com.magicsoft.testeleve.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ShortCutActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 11:28
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create ShortCutActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ShortCutActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private ShortcutManager mShortcutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut);


        Log.e(TAG, "onCreate: "+ Utils.hasShortcut(this,"shortcut")+"||"+getPackageName());
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void twoListener(View view) {//删除其中一个
        //createShortCut();
        mShortcutManager = getSystemService(ShortcutManager.class);
//        List<ShortcutInfo> infos = mShortcutManager.getPinnedShortcuts();
//        for (ShortcutInfo info : infos) {
//            if (info.getId().equals("id" + 0)) {
//                mShortcutManager.disableShortcuts(Arrays.asList(info.getId()), "暂无该联系人");//点击时的提示信息
//            }
//        }
//        mShortcutManager.removeDynamicShortcuts(Arrays.asList("id" + 0));
        removeItem(0);
    }
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    private void removeItem(int index) {
        List<ShortcutInfo> infos = mShortcutManager.getPinnedShortcuts();
        for (ShortcutInfo info : infos) {
            if (info.getId().equals("id" + index)) {
                mShortcutManager.disableShortcuts(Arrays.asList(info.getId()), "暂无该联系人");
            }
        }
        mShortcutManager.removeDynamicShortcuts(Arrays.asList("id" + index));
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void oneListener(View view) {
        //addShortcut(this);
       // Utils.createShortCut(this,"shortcut","这是一个快捷方式",TextActivity.class,"com.magicsoft.shortcut");
        //ShortCutSample.createShortCut(this);
        setupShortcuts();
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupShortcuts() {
        mShortcutManager = getSystemService(ShortcutManager.class);

        List<ShortcutInfo> infos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Intent intent = new Intent(this, TextActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            intent.putExtra("msg", "我和" + i + "的对话");

            ShortcutInfo info = new ShortcutInfo.Builder(this, "id" + i)
                    .setShortLabel(i+"")
                    .setLongLabel("联系人:" + i)
                    .setIcon(Icon.createWithResource(this, R.mipmap.icon_two))
                    .setIntent(intent)
                    .build();
            infos.add(info);
//            manager.addDynamicShortcuts(Arrays.asList(info));
        }

        mShortcutManager.setDynamicShortcuts(infos);
    }

    public void createShortCut(){
        Intent addShortCut;
        //判断是否需要添加快捷方式

            addShortCut = new Intent();
            //快捷方式的名称
            addShortCut.putExtra(Intent.EXTRA_SHORTCUT_NAME , "我的快捷方式");
            //显示的图片
            Parcelable icon = Intent.ShortcutIconResource.fromContext(this, R.mipmap.icon_two);
            addShortCut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
            //快捷方式激活的activity，需要执行的intent，自己定义
            addShortCut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent());
            //OK，生成
            setResult(RESULT_OK, addShortCut);

    }


    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    private void updItem(int index) {
        mShortcutManager = getSystemService(ShortcutManager.class);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra("msg", "我和**" + "的对话");

        ShortcutInfo info = new ShortcutInfo.Builder(this, "id" + index)
                .setShortLabel("hehehheh")
                .setLongLabel("联系人:")
                .setIcon(Icon.createWithResource(this, R.mipmap.icon_two))
                .setIntent(intent)
                .build();

        mShortcutManager.updateShortcuts(Arrays.asList(info));
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void update(View view) {
        updItem(0);
    }
}
