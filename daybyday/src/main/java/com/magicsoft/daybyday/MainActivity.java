package com.magicsoft.daybyday;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.magicsoft.daybyday.activity.EdittextActivity;
import com.magicsoft.daybyday.utils.PhotoAlbum2;
import com.ufo.imageselector.DWImages;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import thinkfreely.changemodelibrary.ChangeModeController;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private FloatingActionButton mFb;
    private Toolbar toolbar;
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private TestRecyclerAdapter mAdapter;
    private TextView mTvTest;
    private boolean isSupportedBade;
    private Intent intent;
    private PhotoAlbum2 mPhoto;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //第一步 当前要立即变色的页面
        ChangeModeController.getInstance().init(this,R.attr.class).setTheme(this, R.style.DayTheme, R.style.NightTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTest = (TextView) findViewById(R.id.tv_mian_text);
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

        //添加额外属性
        //ChangeModeController.getInstance().addTextColor(mTvTest,R.attr.zzTwoTextColor);
        //ChangeModeController.getInstance().addTextColor(mTvTest,R.attr.colorAccent);


//        BadgeNumberManager.from(this).setBadgeNumber(9);


        NotificationManager mNotificationManager = (NotificationManager) this

                .getSystemService(Context.NOTIFICATION_SERVICE);



        Notification.Builder builder = new Notification.Builder(this)

                .setContentTitle("title").setContentText("text").setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();

        try {

            Field field = notification.getClass().getDeclaredField("extraNotification");

            Object extraNotification = field.get(notification);

            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);

            method.invoke(extraNotification, 6);

        } catch (Exception e) {

            e.printStackTrace();

        }

        mNotificationManager.notify(0,notification);


//        int badgeCount = 1;
//        ShortcutBadger.applyCount(this, badgeCount); //for 1.1.4+
//
//        Utils.setBadgeNumber(this,2);
//
//        //BadgeNumberManager.from(this).setBadgeNumber(3);
//
//        Log.e(TAG, "onCreate: "+isSupportedBade );
//        handleBadge(8);
//        BadgeUtil.setBadgeCount(this,8,R.mipmap.ic_launcher);

        //countDown();
        mPhoto = new PhotoAlbum2(this);
    }


    //检测EMUI版本是否支持
    public void checkIsSupportedByVersion(){
        try {
            PackageManager manager = getPackageManager();
            PackageInfo info = manager.getPackageInfo("com.huawei.android.launcher", 0);
            if(info.versionCode>=63029){
                isSupportedBade = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //控制显示的个数
    private void handleBadge(int num){
        if(!isSupportedBade){
            Log.i("badgedemo", "not supported badge!");
            return;
        }
        try{
            Bundle bunlde =new Bundle();
            bunlde.putString("package", "com.example.badgedemo");
            bunlde.putString("class", "com.example.badgedemo.MainActivity");
            bunlde.putInt("badgenumber",num);
            ContentResolver t=this.getContentResolver();
            Bundle result=t.call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_launcher_badge", "", bunlde);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TypedValue attrTypedValue;
        switch (item.getItemId()) {
            case R.id.item_menu_day:
                //第二步 设置切换
                ChangeModeController.changeDay(this, R.style.DayTheme);
                attrTypedValue = ChangeModeController.getAttrTypedValue(this, R.attr.zztextColor);
                toolbar.setTitleTextColor(getResources().getColor(attrTypedValue.resourceId));
                break;
            case R.id.item_menu_night:
                ChangeModeController.changeNight(this, R.style.NightTheme);
                attrTypedValue = ChangeModeController.getAttrTypedValue(this, R.attr.zztextColor);
                toolbar.setTitleTextColor(getResources().getColor(attrTypedValue.resourceId));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //第三步   在onDestroy调用
        ChangeModeController.onDestory();
    }

    public void toNext(View view) {
        startActivity(new Intent(this, EdittextActivity.class));
        //DWImages.cropImage(MainActivity.this,mOnePath,5,5,400,400);
    }

    public void shortCut(View view) {

//        Log.e(TAG, "shortCut: "+ ShortcutSuperUtils.isShortCutExist(this,"short"));
//        intent = new Intent(this, TextActivity.class);
//        ShortcutUtils.addShortcut(this,intent,"short",false, BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        DWImages.getImages(this, DWImages.ACTION_CAMERA, 1);

        //mPhoto.takePhoto();
    }

    public void remove(View view) {
        DWImages.getImages(this, DWImages.ACTION_ALBUM, 6);
        //ShortcutUtils.removeShortcut(this,intent,"short");
        //mPhoto.openAlbum();
    }

    String mOnePath;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: " +requestCode);

            //就加上这行代码
            DWImages.parserResult(requestCode, data, new DWImages.GetImagesCallback() {
                @Override
                public void onResult(List<String> images) {
                    //这里返回选择的图片路径
                    Log.e(TAG, "onResult: "+images.get(0).toString());

                    mOnePath=images.get(0).toString();
                }
            });

            Log.e(TAG, "onActivityResult: 2030"+(data==null) );
            DWImages.parserCropResult(requestCode, data, new DWImages.CropImageCallback() {
                @Override
                public void onResult(String images) {
                    Log.d(TAG, "onResult:--> Crop path: " + images);
                    Log.d(TAG, "onResult:--> Crop size: " + new File(images).length());
                }
            });

        //Bitmap bitmap = mPhoto.onActivityResult(requestCode, resultCode, data);



    }

    public  void countDown(){
//         new CountDownTimer(1000 * 10, 1000) {//第一个参数,总时间;第二个参数,间隔时间
//            @Override
//            public void onTick(long l) {
//                System.out.println(l);
//            }
//
//            @Override
//            public void onFinish() {
//                System.out.println("finish");
//            }
//        }.start();
//        //cdt.cancel();

        CountDownTimer countDownTimer
                = new CountDownTimer(1000*2,1000) {
            @Override
            public void onTick(long l) {
                Log.e(TAG, "onTick: "+l );
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "onFinish: "+"finish" );
            }
        };
        countDownTimer.start();
    }
}
