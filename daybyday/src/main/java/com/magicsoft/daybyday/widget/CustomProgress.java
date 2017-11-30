package com.magicsoft.daybyday.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomProgress extends View {

    private Paint mPaint;

    /**
     * 圆的宽度
     */
    private int mCircleWidth = 5;

    public CustomProgress(Context context) {
        this(context, null);
    }

    public CustomProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setAntiAlias(true);//取消锯齿
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setColor(Color.CYAN);

        /**
         * 这是一个居中的圆
         */
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

//        RectF oval = new RectF( x, y,
//                getWidth() - x, getHeight() - y);

        RectF oval = new RectF( 10, 10,
                getWidth()-10 , getHeight()-10);



        canvas.drawArc(oval,135,270,false,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        for (int i = 1; i < 90; i++) {
            canvas.drawPoint(getWidth()/i,getHeight()/i,mPaint);
        }

    }
}