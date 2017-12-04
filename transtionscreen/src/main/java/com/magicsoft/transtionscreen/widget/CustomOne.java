package com.magicsoft.transtionscreen.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.magicsoft.transtionscreen.utils.DensityUtils;

import static com.magicsoft.transtionscreen.activity.WechatActivity.TAG;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CustomOne.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 10:29
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create CustomOne.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CustomOne extends View {
    private Context mContext ;

    public CustomOne(Context context) {
        super(context);
        mContext=context;
    }

    public CustomOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    public CustomOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//自己测量
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
        int result;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);

        if (mode==MeasureSpec.EXACTLY){
            result=size;
        }else {
            result=200;
            if (mode==MeasureSpec.AT_MOST){
                result=Math.min(result,size);
            }

        }

        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int px = DensityUtils.getInstance().dp2px(mContext, 200);
        int result=0;
        //获取测量模式和测量的大小
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        Log.e(TAG, "measureWidth: "+mode+"||"+size+"||"+px);
        if (mode==MeasureSpec.EXACTLY){
            result=size;
        }else {
            result= 200;
            if (mode==MeasureSpec.AT_MOST){
                result=Math.min(result,size);
            }
        }
        return result;
    }
}
