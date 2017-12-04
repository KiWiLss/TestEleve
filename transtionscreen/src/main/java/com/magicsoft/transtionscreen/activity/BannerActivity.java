package com.magicsoft.transtionscreen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.magicsoft.transtionscreen.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: BannerActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/1 10:14
 * @Changes (from 2017/12/1)
 * -----------------------------------------------------------------
 * 2017/12/1 : Create BannerActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class BannerActivity extends AppCompatActivity {


    private TextView mTvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        initView();
        mTvText.setMaxLines(3);
        mTvText.setEllipsize(TextUtils.TruncateAt.END);
        initEvent();
    }

    private void initEvent() {
        mTvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvText.setMaxLines(10);
            }
        });
    }

    private void initView() {
        mTvText = (TextView) findViewById(R.id.tv_banner_text);
    }
}
