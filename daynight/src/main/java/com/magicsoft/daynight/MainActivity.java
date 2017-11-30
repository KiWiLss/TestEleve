package com.magicsoft.daynight;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCompatActivity;

public class MainActivity extends SkinCompatActivity {


    public static final String TAG = "MMM";
    private Button btn_theme;
    private RelativeLayout relativeLayout;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }




    public void dayListener(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        recreate();
    }

    public void nightListener(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        recreate();
    }

    public void toNext(View view) {
        Toast.makeText(this, "red", Toast.LENGTH_SHORT).show();
// 指定皮肤插件, 并且监听加载状态

        SkinCompatManager.getInstance().loadSkin("night", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);


    }

    public void reverNext(View view) {
        // 恢复应用默认皮肤
        SkinCompatManager.getInstance().restoreDefaultTheme();
    }
}
