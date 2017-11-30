package com.magicsoft.day;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private FloatingActionButton mFb;
    private Toolbar toolbar;
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private TestRecyclerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //第一步 当前要立即变色的页面
        //ChangeModeController.getInstance().init(this,R.attr.class).setTheme(this, R.style.DayTheme, R.style.NightTheme);

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)this.findViewById(R.id.recyclerView);
        //设置固定大小
        recyclerView.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager = new LinearLayoutManager(this);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
        recyclerView.setLayoutManager(mLayoutManager);
        //创建适配器，并且设置
        mAdapter = new TestRecyclerAdapter(this);
        recyclerView.setAdapter(mAdapter);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //3.   在onDestroy调用
        ChangeModeController.onDestory();
    }

    boolean isNight;
    public void changeListener(View view) {
       TypedValue attrTypedValue;
        if (isNight){
            //第二步 设置切换
            ChangeModeController.changeDay(this, R.style.DayTheme);
            attrTypedValue = ChangeModeController.getAttrTypedValue(this, R.attr.zztextColor);
            toolbar.setTitleTextColor(getResources().getColor(attrTypedValue.resourceId));
        }else {
            //第二步 设置切换
            ChangeModeController.changeDay(this, R.style.NightTheme);
            attrTypedValue = ChangeModeController.getAttrTypedValue(this, R.attr.zztextColor);
            toolbar.setTitleTextColor(getResources().getColor(attrTypedValue.resourceId));
        }
        isNight=!isNight;
    }
}
