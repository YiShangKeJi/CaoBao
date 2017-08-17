package com.ys.caobao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ys.caobao.util.AppManager;

/**
 * 基准Activity
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
    }

    protected  void setLayoutView(int layout){
        setContentView(layout);
        initView();
        initData();
    }

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化data
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        AppManager.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}

