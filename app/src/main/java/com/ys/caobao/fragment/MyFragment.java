package com.ys.caobao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ys.caobao.R;
import com.ys.caobao.activity.LoginActivity;

public class MyFragment extends Fragment implements OnClickListener {
    public View view;
    public Activity activity;

    private TextView tv_login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        view = inflater.inflate(R.layout.fragment_my, null);
        initView();
        return view;
    }

    private void initView() {
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                Intent intent_login = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent_login);
                break;
        }

    }
}
