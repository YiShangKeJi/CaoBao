package com.ys.caobao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.caobao.R;
import com.ys.caobao.activity.AboutActivity;
import com.ys.caobao.activity.DiscountActivity;
import com.ys.caobao.activity.FriendActivity;
import com.ys.caobao.activity.LoginActivity;
import com.ys.caobao.activity.SetActivity;
import com.ys.caobao.dialog.ServiceDialog;

public class MyFragment extends Fragment implements OnClickListener {
    public View view;
    public Activity activity;

    private TextView tv_login;
    private LinearLayout ll_about;
    private LinearLayout ll_service;
    private LinearLayout ll_discount;
    private LinearLayout ll_friend;
    private ImageView iv_set;
    //
    private ServiceDialog serviceDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        view = inflater.inflate(R.layout.fragment_my, null);
        initView();
        initData();
        return view;
    }

    private void initData() {
        serviceDialog = new ServiceDialog(activity);
    }

    private void initView() {
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        ll_about = (LinearLayout) view.findViewById(R.id.ll_about);
        ll_service = (LinearLayout) view.findViewById(R.id.ll_service);
        ll_discount = (LinearLayout) view.findViewById(R.id.ll_discount);
        ll_friend = (LinearLayout) view.findViewById(R.id.ll_friend);
        iv_set = (ImageView) view.findViewById(R.id.iv_set);
        tv_login.setOnClickListener(this);
        ll_about.setOnClickListener(this);
        ll_service.setOnClickListener(this);
        ll_discount.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        iv_set.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                Intent intent_login = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent_login);
                break;
            case R.id.iv_set:
                Intent intent_set = new Intent(getActivity(), SetActivity.class);
                startActivity(intent_set);
                break;
            case R.id.ll_about:
                Intent intent_about = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent_about);
                break;
            case R.id.ll_service:
                serviceDialog.showDialog();
                break;
            case R.id.ll_discount:
                Intent intent_discount = new Intent(getActivity(), DiscountActivity.class);
                startActivity(intent_discount);
                break;
            case R.id.ll_friend:
                Intent intent_friend = new Intent(getActivity(), FriendActivity.class);
                startActivity(intent_friend);
                break;
        }

    }
}
