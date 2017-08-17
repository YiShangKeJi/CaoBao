package com.ys.caobao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ys.caobao.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class LoginActivity extends BaseActivity {

    private RelativeLayout rl_back;
    private TextView tv_title;
    private TextView tv_register;
    private TextView tv_forget_pwd;
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        rl_back = (RelativeLayout) findViewById(R.id.rl_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_forget_pwd = (TextView) findViewById(R.id.tv_forget_pwd);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_title.setText("登录");
        rl_back.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.tv_forget_pwd:
                break;
        }
    }
}
