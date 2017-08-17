package com.ys.caobao.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.ys.caobao.R;

/**
 * 启动页
 */
public class StartActivity extends BaseActivity {
    private Runnable runnable;
    private Handler handler;
    private SharedPreferences preferences;
    private int useCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setLayoutView(R.layout.activity_start);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        preferences = getSharedPreferences("use", this.MODE_PRIVATE);
        useCount = preferences.getInt("count", 0);
        runnable = new Runnable() {

            @Override
            public void run() {
                if (useCount == 1) {
                    Intent intent = new Intent(StartActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                } else if (useCount == 0) {
                    Intent intent = new Intent(StartActivity.this,
                            GuideActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        };
        handler = new Handler();
        handler.postDelayed(runnable, 1000);
    }

}