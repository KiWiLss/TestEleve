package com.magicsoft.daybyday.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.magicsoft.daybyday.R;

/**
 * Created by lyf on 2017/11/28/028.
 */

public class Progress extends View {

    private String numStr = "0";//显示
    private String allStr = "0";//总里程
    private String unitlStr = "0";//单位
    private String rankStr = "0";//排名


    private int diameter = 250;//半径
    private float centerX;
    private float centerY;

    private RectF bgRect;

    private float bgArcWidth = dipToPx(5);// 圆弧宽度
    private float progressWidth = dipToPx(5);// 进度条宽度
    private Paint allArcPaint;  //圆弧画笔

    private Canvas canvas;
    private PaintFlagsDrawFilter mDrawFilter;
    private float startAngle = 135;
    private float sweepAngle = 270;

    //单位
    private Paint uintPaint;
    private float uintSize = dipToPx(15);
    private String uintColor = "#676767";


    private float textSize = dipToPx(60);
    private Paint vTextPaint;


    private Paint allPaint;
    private float allSize = dipToPx(13);
    private String allColor = "#676767";
    private Paint rankPaint;
    private float rankSize = dipToPx(13);
    private String rankColor = "#676767";
    private Paint rankrecPaint;
    private RectF r2;
    private float currentAngle = 0;
    private Paint progressPaint;
    private float curValues = 0;//距离
    private float lastAngle;
    private ValueAnimator progressAnimator;
    private float k;
    private float maxValues;
    private int ScrHeight;
    private int ScrWidth;
    private int allPoint = 0;


    public Progress(Context context) {
        super(context);
        initView();
    }

    public Progress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCofig(context, attrs);
        initView();
    }


    public Progress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCofig(context, attrs);
        initView();
    }

    private void initCofig(Context context, AttributeSet attrs) {
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.Progress);
        numStr = t.getString(R.styleable.Progress_text_num);
        allStr = t.getString(R.styleable.Progress_text_all);
        unitlStr = t.getString(R.styleable.Progress_text_nuit);
        rankStr = t.getString(R.styleable.Progress_text_rank);

        t.recycle();
    }


    private void initView() {
        diameter = getScreenWidth() * 4 / 5;

        //弧形的矩阵区域
        bgRect = new RectF();
        bgRect.top = progressWidth / 2;
        bgRect.left = progressWidth / 2;
        bgRect.right = diameter + progressWidth / 2;
        bgRect.bottom = diameter + progressWidth / 2;

        //圆心
        centerX = progressWidth + diameter / 2;
        centerY = progressWidth + diameter / 2;

        //整个弧形
        allArcPaint = new Paint();
        allArcPaint.setAntiAlias(true);
        allArcPaint.setStyle(Paint.Style.STROKE);
        allArcPaint.setStrokeWidth(bgArcWidth);
        allArcPaint.setColor(Color.parseColor("#F0ECEC"));
        allArcPaint.setStrokeCap(Paint.Cap.ROUND);

        //当前进度的弧形
        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint.setStrokeWidth(progressWidth);
        progressPaint.setColor(Color.parseColor("#FEAA7D"));

        //内容显示文字
        vTextPaint = new Paint();
        vTextPaint.setTextSize(textSize);
        vTextPaint.setColor(Color.BLACK);
        vTextPaint.setTextAlign(Paint.Align.CENTER);


        //显示单位文字
        uintPaint = new Paint();
        uintPaint.setTextSize(uintSize);
        uintPaint.setColor(Color.parseColor(uintColor));
        uintPaint.setTextAlign(Paint.Align.CENTER);

        //显示总共长度文字
        allPaint = new Paint();
        allPaint.setTextSize(allSize);
        allPaint.setColor(Color.parseColor(allColor));
        allPaint.setTextAlign(Paint.Align.CENTER);

        //显示排名
        rankPaint = new Paint();
        rankPaint.setTextSize(rankSize);
        rankPaint.setColor(Color.parseColor(rankColor));
        rankPaint.setTextAlign(Paint.Align.CENTER);

        rankrecPaint = new Paint();
        rankrecPaint.setAntiAlias(true);                       //设置画笔为无锯齿
        rankrecPaint.setColor(Color.DKGRAY);                    //设置画笔颜色
        rankrecPaint.setStrokeWidth((float) 3.0);              //线宽
        rankrecPaint.setStyle(Paint.Style.STROKE);                   //空心效果
        r2 = new RectF();                           //RectF对象
        r2.left = centerX - rankSize * rankStr.length() - uintSize;                                 //左边
        r2.top = centerY + rankSize * rankStr.length() + uintSize;                                 //上边
        r2.right = centerX + rankSize * rankStr.length() + uintSize;                                   //右边
        r2.bottom = centerY + rankSize * rankStr.length() * 2 + uintSize / 2;                              //下边

        mDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ScrHeight = this.getMeasuredHeight();
        ScrWidth = this.getMeasuredWidth();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        //抗锯齿
        canvas.setDrawFilter(mDrawFilter);


        //整个弧
        canvas.drawArc(bgRect, startAngle, sweepAngle, false, allArcPaint);

        //当前进度
        canvas.drawArc(bgRect, startAngle, currentAngle, false, progressPaint);
        //画刻度线
        for (int i = 0; i < 40; i++) {
            if (i > 15 && i < 25) {
                canvas.rotate(9, centerX, centerY);
                continue;
            }

            canvas.drawPoint(centerX, centerY - diameter / 2 + progressWidth * 3, allArcPaint);//画一个点

            canvas.rotate(9, centerX, centerY);
        }

        for (int i = 0; i < 40; i++) {

            if (i > 15 && i < 25) {
                canvas.rotate(9, centerX, centerY);
                continue;
            }
            if (allPoint<=i) {
                Log.d("lyf",allPaint+"");
                canvas.drawPoint(centerX, centerY - diameter / 2 + progressWidth * 3, progressPaint);//画一个点
            }

            canvas.rotate(9, centerX, centerY);
        }

        canvas.drawText(numStr, centerX, centerY - uintSize * 2, vTextPaint);

        canvas.drawText(unitlStr, centerX, centerY, uintPaint);
        canvas.drawText(allStr, centerX, centerY + uintSize * 3, allPaint);
        canvas.drawRoundRect(r2, centerX, centerY + uintSize * 5, rankrecPaint);
        canvas.drawText(rankStr, centerX, centerY + uintSize * 5, rankPaint);

        invalidate();
    }

    /**
     * 设置最大值
     *
     * @param maxValues
     */
    public void setMaxValues(float maxValues) {
        this.maxValues = maxValues;
        k = sweepAngle / maxValues;
    }

    /**
     * 设置当前值
     *
     * @param currentValues
     */
    public void setCurrentValues(float currentValues) {
        if (currentValues > maxValues) {
            currentValues = maxValues;
        }
        if (currentValues < 0) {
            currentValues = 0;
        }
        this.curValues = currentValues;
        lastAngle = currentAngle;
        allPoint = (int) (40*currentValues/maxValues);

        setAnimation(lastAngle, currentValues * k, 1000);
    }


    /**
     * 为进度设置动画
     *
     * @param last
     * @param current
     */
    private void setAnimation(float last, float current, int length) {
        progressAnimator = ValueAnimator.ofFloat(last, current);
        progressAnimator.setDuration(length);
        progressAnimator.setTarget(currentAngle);
        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentAngle = (float) animation.getAnimatedValue();
                curValues = currentAngle / k;
            }
        });
        progressAnimator.start();
    }

    /**
     * dip 转换成px
     *
     * @param dip
     * @return
     */
    private int dipToPx(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }

    /**
     * 得到屏幕宽度
     *
     * @return
     */
    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
