package com.magicsoft.testeleve.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import com.magicsoft.testeleve.R;
import com.magicsoft.testeleve.utils.TvUtils;
import com.magicsoft.testeleve.widget.FrameSpan;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: TextActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/11/24 15:35
 * @Changes (from 2017/11/24)
 * -----------------------------------------------------------------
 * 2017/11/24 : Create TextActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class TextActivity extends AppCompatActivity {

    private TextView mTvFore;
    private TextView mTvFore2;
    private TextView mTvFore3;
    private TextView mTvFore4;
    private TextView mTvFore5;
    private TextView mTvFore6;
    private TextView mTvFore7;
    private TextView mTvFore8;
    private TextView mTvFore9;
    private TextView mTvFore10;
    private TextView mTvFore11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        initViews();
        setFore();

    }

    private void setFore() {
        String text="大小颜色位置部分文字前景色";

        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);

        SpannableString spannableString = new SpannableString(text);

        spannableString.setSpan(sizeSpan04, 3, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);//设置部分文字大小

        spannableString.setSpan(new ForegroundColorSpan(Color.RED),text.length()-3,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvFore.setText(spannableString);

        SpannableString ss = TvUtils.setTextPartColor(text, "文字", ContextCompat.getColor(this,R.color.colorAccent));
        mTvFore2.setText(ss);

        mTvFore3.setText(TvUtils.setTextPartTextSize(text,"文字前",20));

        mTvFore4.setText(TvUtils.setStrikethrough(text,4,text.length()));

        mTvFore5.setText(TvUtils.setUpScript(text,0,4));

        mTvFore6.setText(TvUtils.setDownScript(text,text.length()-4,text.length()));

        mTvFore7.setText(TvUtils.setUpDownLine(text,"大小","部分文字前景色"));

        mTvFore8.setText(TvUtils.setTextBold(text,6,8));

        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        ContextCompat.getDrawable(this,R.mipmap.ic_launcher);
        mTvFore9.setText(TvUtils.setTextIcon(text,4,6,drawable));

        handler.sendEmptyMessageDelayed(0x158, 150);

        String text11 = mTvFore11.getText().toString();
        SpannableString spannableString11 = new SpannableString(text11);
        spannableString11.setSpan(new FrameSpan(),4,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvFore11.setText(spannableString11);
    }

    private void initViews() {
        mTvFore = (TextView) findViewById(R.id.tv_text_fore);
        mTvFore2 = (TextView) findViewById(R.id.tv_text_fore2);
        mTvFore3 = (TextView) findViewById(R.id.tv_text_fore3);
        mTvFore4 = (TextView) findViewById(R.id.tv_text_fore4);
        mTvFore5 = (TextView) findViewById(R.id.tv_text_fore5);
        mTvFore6 = (TextView) findViewById(R.id.tv_text_fore6);
        mTvFore7 = (TextView) findViewById(R.id.tv_text_fore7);
        mTvFore8 = (TextView) findViewById(R.id.tv_text_fore8);
        mTvFore9 = (TextView) findViewById(R.id.tv_text_fore9);
        mTvFore10 = (TextView) findViewById(R.id.tv_text_fore10);
        mTvFore11 = (TextView) findViewById(R.id.tv_text_fore11);


    }
    private int position = 0;
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x158:
                    SpannableString spannableString = new SpannableString("这是摇动的的风景曼妮芬低筋粉非额");

                    RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.2f);
                    spannableString.setSpan(sizeSpan, position, position + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    mTvFore10.setText(spannableString);
                    position++;
                    if(position >= mTvFore10.getText().toString().length()) {
                        position = 0;
                    }
                    handler.sendEmptyMessageDelayed(0x158, 150);
                    break;
            }
        }
    };
}
