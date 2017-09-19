package com.ys.caobao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ys.caobao.R;
import com.ys.caobao.parsesaop.ParseSoapStringResultInfo;
import com.ys.caobao.parsesaop.StringResultInfo;
import com.ys.caobao.request.User.Login;
import com.ys.caobao.request.User.RegistUser;
import com.ys.caobao.webservice.WebserviceMethod;

import org.ksoap2.serialization.SoapObject;

/**
 * Created by Administrator on 2017/6/9.
 */

public class LoginActivity extends BaseActivity {

    private RelativeLayout rl_back;
    private TextView tv_title;
    private TextView tv_register;
    private TextView tv_forget_pwd;
    private TextView tv_login;
    private EditText phone_Num,passWord;
    private final int Handler_Login = 0X01;
    private Handler handler =new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Handler_Login:
                    StringResultInfo parse = ParseSoapStringResultInfo
                            .parse((SoapObject) msg.obj);
                    if(parse.OkFlag){
                        String [] split = parse.Data.toString().split(";");
                    }
                    break;
                default:
                    break;
            }
        }
    };
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
        phone_Num = (EditText)findViewById(R.id.phone_num);
        passWord = (EditText)findViewById(R.id.password);
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
                login();
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

    private void login() {
        String userID =phone_Num.getText().toString();
        String password =passWord.getText().toString();
        if(userID.equals("")){
            Toast.makeText(LoginActivity.this,"手机号不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.equals("")){
            Toast.makeText(LoginActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        Login regisUser = new Login();
        regisUser.userID=userID;
        regisUser.userPsw =password;
        WebserviceMethod.User.Login(handler,Handler_Login,regisUser);
    }
}
