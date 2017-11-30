package com.magicsoft.testeleve.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.fixedfloatwindow.FixedFloatWindow;
import com.magicsoft.testeleve.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: SuspendActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/27 10:39
 * @Changes (from 2017/11/27)
 * -----------------------------------------------------------------
 * 2017/11/27 : Create SuspendActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class SuspendActivity extends Activity {
    private FixedFloatWindow fixedFloatWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend);

    }

    public void showListener(View view) {

        //((MyApp) getApplication()).getMyFloatWindow().show();


         fixedFloatWindow = new FixedFloatWindow(getApplicationContext());
        View dialogView = LayoutInflater.from(this).inflate(R.layout.suspend_dialog, null);
        fixedFloatWindow.setView(dialogView);

        fixedFloatWindow.setGravity(Gravity.RIGHT | Gravity.TOP, 100, 150);
        fixedFloatWindow.show();

        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "悬浮窗", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void hideListener(View view) {
        //((MyApp) getApplication()).getMyFloatWindow().hide();

    }

    public void updata(View view) {

    }

}
