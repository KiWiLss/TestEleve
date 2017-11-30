package com.magicsoft.daybyday.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.magicsoft.daybyday.R;
import com.magicsoft.daybyday.widget.AddSpaceTextWatcher;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: EdittextActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/30 15:05
 * @Changes (from 2017/11/30)
 * -----------------------------------------------------------------
 * 2017/11/30 : Create EdittextActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class EdittextActivity extends AppCompatActivity {

    private EditText mEt;
    private EditText mEt2;
    private EditText mEt3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        initView();

        AddSpaceTextWatcher atw = new AddSpaceTextWatcher(mEt, 23);
        atw.setSpaceType(AddSpaceTextWatcher.SpaceType.bankCardNumberType);

        AddSpaceTextWatcher atw2 = new AddSpaceTextWatcher(mEt2, 13);
        atw2.setSpaceType(AddSpaceTextWatcher.SpaceType.mobilePhoneNumberType);

        AddSpaceTextWatcher atw3 = new AddSpaceTextWatcher(mEt3, 21);
        atw3.setSpaceType(AddSpaceTextWatcher.SpaceType.IDCardNumberType);
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.editText);
        mEt2 = (EditText) findViewById(R.id.editText2);
        mEt3 = (EditText) findViewById(R.id.editText3);

    }
}
