package com.magicsoft.daybyday.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.magicsoft.daybyday.R;

/**
 * 自定义带圆点的进度条
 */
public class HalfProgressBar extends View {
    private int maxProgress = 100;
    //设置进度条背景宽度
    private float progressStrokeWidth = 3;
    //设置进度条进度宽度
    private float marxArcStorkeWidth = 6;
    //设置进度条圆点的宽度
    private float circularDotWidth=15;


    /**
     * 画笔对象的引用
     */
    private Paint paint;

    public synchronized int getProgress() {
        return progress;
    }

    /**
     * Android提供了Invalidate方法实现界面刷新，但是Invalidate不能直接在线程中调用，因为他是违背了单线程模型：Android UI操作并不是线程安全的，并且这些操作必须在UI线程中调用。
     *  而postInvalidate()在工作者线程中被调用 使用postInvalidate则比较简单，不需要handler，直接在线程中调用postInvalidate即可。 
     * @param progress 传过来的进度
     */
    public void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        }
        if (progress > maxProgress) {
            progress = maxProgress;
        }
        if (progress <= maxProgress) {
            this.progress = progress;
            postInvalidate();
        }
    }
    /**
     * 当前进度
     */
    private int progress = 99;

    private RectF oval;
    private int roundProgressColor;
    private int roundColor;
    private int circularDotColor;
    public HalfProgressBar(Context context) {
        super(context);
    }

    public HalfProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        oval = new RectF();
        //这是自定义view 必须要写的
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.HalfProgressBar);
        roundProgressColor = mTypedArray.getColor(R.styleable.HalfProgressBar_roundProgressColor1, Color.RED);
        roundColor=mTypedArray.getColor(R.styleable.HalfProgressBar_roundColor1, Color.BLUE);
        circularDotColor=mTypedArray.getColor(R.styleable.HalfProgressBar_circularDotColor1, Color.YELLOW);

    }

    public HalfProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        oval = new RectF();
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.HalfProgressBar);
        roundProgressColor = mTypedArray.getColor(R.styleable.HalfProgressBar_roundProgressColor1, Color.RED);
        roundColor=mTypedArray.getColor(R.styleable.HalfProgressBar_roundColor1, Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO 自动生成的方法存根
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        paint.setAntiAlias(false); // 设置画笔为抗锯齿
        paint.setColor(roundColor); // 设置画笔颜色

        paint.setStrokeWidth(progressStrokeWidth); // 线宽
        paint.setStyle(Paint.Style.STROKE);

        oval.left = marxArcStorkeWidth / 2; // 左上角x
        oval.top = circularDotWidth; // 左上角y
        oval.right = width - circularDotWidth / 2; // 左下角x
        oval.bottom = width - circularDotWidth / 2; // 右下角y
        float bangjing = ((width - circularDotWidth/2) / 2);//半径


        //调整圆背景的大小
        canvas.drawArc(oval, 200, 200, false, paint); // 绘制红丝圆圈，即进度条背景
        //进度条颜色
        paint.setColor(roundProgressColor);
        paint.setStrokeWidth(marxArcStorkeWidth);
        canvas.drawArc(oval, 180, 180 * ((float) progress / (float) maxProgress), false, paint); // 绘制进度圆弧，这里是蓝色


        //画圆点
        paint.setColor(circularDotColor);
        paint.setAntiAlias(true); // 设置画笔为抗锯齿
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(circularDotWidth*2);
        //当画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的图形样式，如圆形样式Cap.ROUND,或方形样式Cap.SQUARE
        paint.setStrokeCap(Paint.Cap.ROUND);
        float jindu = ((float) progress * 1.8f);
        canvas.drawPoint(bangjing - ((float) (Math.sin((Math.PI / (double) 180) * (jindu <= 90 ? 90 - (jindu) : -jindu + 90))) * bangjing),
         bangjing+circularDotWidth - ((float) (Math.cos((Math.PI / (double) 180) * (double) (jindu <= 90 ? 90 - jindu : -jindu + 90))) * bangjing), paint);


    }

}