package com.magicsoft.daybyday.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

import com.magicsoft.daybyday.R;
import com.magicsoft.daybyday.fragment.TextFragment;
import com.magicsoft.daybyday.widget.Progress;

import thinkfreely.changemodelibrary.ChangeModeController;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: TextActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/28 14:02
 * @Changes (from 2017/11/28)
 * -----------------------------------------------------------------
 * 2017/11/28 : Create TextActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class TextActivity extends AppCompatActivity {

    private FrameLayout mFl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //第一步 当前要立即变色的页面
        ChangeModeController.getInstance().init(this,R.attr.class).setTheme(this, R.style.DayTheme, R.style.NightTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Progress mP = (Progress) findViewById(R.id.p_text);

        mP.setMaxValues(100);
        mP.setCurrentValues(40);

        mFl = (FrameLayout) findViewById(R.id.fl_text);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fl_text,new TextFragment()).commit();



    }
    boolean isNight;
    public void change(View view) {
        TypedValue attrTypedValue;
        if (isNight){
            ChangeModeController.changeDay(this, R.style.DayTheme);
            //attrTypedValue = ChangeModeController.getAttrTypedValue(this, R.attr.zztextColor);
        }else {
            ChangeModeController.changeDay(this, R.style.NightTheme);
        }
        isNight=!isNight;
    }
}
