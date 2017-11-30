package com.magicsoft.testeleve;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.fixedfloatwindow.FixedFloatWindow;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yhao on 17-11-16.
 * 管理应用内悬浮窗
 * 实现 ActivityLifecycleCallbacks 是为了更方便的获取 activity 界面状态，从而更方便的管理
 */

public class MyFloatWindow implements Application.ActivityLifecycleCallbacks {


    private Context mAppContext;
    private View mView;
    private FixedFloatWindow mFixedFloatWindow;

    private int mActivityNum; //用于判断应用是否处于前台，若处于后台需要隐藏悬浮窗，否则就会在桌面显示

    private int mRotation; //当前角度

    private boolean playing = true; //用于控制定时器中是否需要改变悬浮控件角度


    public MyFloatWindow(Context mAppContext) {
        this.mAppContext = mAppContext;
        initView();
        initTimer();
    }


    /**
     * 初始化定时器
     */
    private void initTimer() {

        Timer timer = new Timer();
        TimerTask timeTask = new TimerTask() {
            @Override
            public void run() {
                if (playing) {
                    updateRotation();
                    mView.post(new Runnable() {
                        @Override
                        public void run() {
                            mView.setRotation(mRotation);
                        }
                    });
                }
            }
        };
        timer.schedule(timeTask, 0, 50);
    }


    /**
     * 初始化悬浮窗
     */
    private void initView() {
        mView=LayoutInflater.from(mAppContext).inflate(R.layout.suspend_dialog,null);
//        ImageView imageView = new ImageView(mAppContext);
//        imageView.setBackgroundResource(R.mipmap.icon_one);
//        mView = imageView;
        mView.setVisibility(View.INVISIBLE);

        mFixedFloatWindow = new FixedFloatWindow(mAppContext);
        //mFixedFloatWindow.setView(mView,120,120);
        mFixedFloatWindow.setView(mView);
        mFixedFloatWindow.setGravity(Gravity.RIGHT | Gravity.TOP, 60, 60);
        mFixedFloatWindow.show();


    }


    /**
     * 显示悬浮窗
     */
    public void show() {
        mView.setVisibility(View.VISIBLE);
    }


    /**
     * 隐藏悬浮窗
     */
    public void hide() {
        mView.setVisibility(View.INVISIBLE);
    }


    /**
     * FixedFloatWindow 的 hide 方法调用后不可再 show 显示出来
     * 实际上 hide 方法名不严谨，应该是 dismiss 的意思 ，查看源码就明白了
     * 若无意专门销毁悬浮窗，一般不需要调用此方法
     */
    public void dismiss() {//一旦销毁就无法再次调用
        mFixedFloatWindow.hide();
    }



    /**
     * 更新角度，实现旋转
     */
    private void updateRotation() {
        mRotation++;
        if (mRotation == 360) {
            mRotation = 0;
        }
    }


    /**
     * 此方法用于指定哪些界面需要展示悬浮窗
     */
    private boolean isNeedShow(Activity activity) {//自动显示
        return (activity instanceof MainActivity || activity instanceof MainActivity);
    }


    @Override
    public void onActivityStarted(Activity activity) {
        mActivityNum++;
        if (isNeedShow(activity)) {
            show();
        }else{
            hide();
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
        mActivityNum--;
        if (mActivityNum == 0) {
            hide();
        }
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }


    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
