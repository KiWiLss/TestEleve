package com.magicsoft.daybyday.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.magicsoft.daybyday.R;
import com.maning.mndialoglibrary.MProgressDialog;
import com.maning.mndialoglibrary.MToast;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: DialogActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/30 14:14
 * @Changes (from 2017/11/30)
 * -----------------------------------------------------------------
 * 2017/11/30 : Create DialogActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        //新建一个Dialog
        MProgressDialog mMProgressDialog = new MProgressDialog.Builder(this)
                //点击外部是否可以取消
                .isCanceledOnTouchOutside(true)
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(Color.TRANSPARENT)
                //View背景的颜色
                //.setBackgroundViewColor(Color.TRANSPARENT)
                //View背景的圆角
                .setCornerRadius(10)

                //View 边框的颜色
                //.setStrokeColor(getMyColor(R.color.colorAccent))
                //View 边框的宽度
                .setStrokeWidth(2)
                //Progress 颜色
                .setProgressColor(Color.TRANSPARENT)
                //Progress 宽度
                .setProgressWidth(3)
                //Progress 内圈颜色
                .setProgressRimColor(Color.YELLOW)
                //Progress 内圈宽度
                .setProgressRimWidth(2)
                //文字的颜色
                //.setTextColor(getMyColor(R.color.colorDialogTextColor))
                //取消的监听
                .setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
                    @Override
                    public void dismiss() {
                        //mHandler.removeCallbacksAndMessages(null);
                        MToast.makeTextShort(DialogActivity.this, "Dialog消失了").show();
                    }
                })
                .build();
        mMProgressDialog.show();
    }
}
