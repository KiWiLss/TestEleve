package com.magicsoft.transtionscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CustomTextView1.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 11:12
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create CustomTextView1.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CustomTextView1 extends TextView {//绘制多层背景
    public CustomTextView1(Context context) {
        this(context,null);
    }

    public CustomTextView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomTextView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //在回调父类方法前,实现自己的逻辑,对textview来说就是绘制文本内容前
        super.onDraw(canvas);
        //在回调父类方法后,实现自己的逻辑,对textview来说就是绘制文本内容后
        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.FILL);

        Paint paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }
}
