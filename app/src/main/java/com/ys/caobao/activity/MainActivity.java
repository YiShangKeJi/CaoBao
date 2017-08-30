package com.ys.caobao.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.caobao.R;
import com.ys.caobao.adapter.FragmentAdapter;
import com.ys.caobao.fragment.MyFragment;
import com.ys.caobao.fragment.HomeFragment;
import com.ys.caobao.fragment.ShopFragment;
import com.ys.caobao.fragment.OrderFragment;
import com.ys.caobao.util.AppManager;
import com.ys.caobao.view.AppViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MainActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private ShopFragment shopFragment;
    private MyFragment myFragment;
    private AppViewPager vp_manage;
    private List<Fragment> fragments;
    private FragmentAdapter adapter;
    private LinearLayout ll_home;
    private LinearLayout ll_order;
    private LinearLayout ll_shop;
    private LinearLayout ll_my;
    private ImageView iv_home, iv_order, iv_shop, iv_my;
    private TextView tv_home, tv_order, tv_shop, tv_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        //初始化Fragment
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        shopFragment = new ShopFragment();
        myFragment = new MyFragment();
        fragments.add(homeFragment);
        fragments.add(orderFragment);
        fragments.add(shopFragment);
        fragments.add(myFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        //预加载4张，避免切换闪屏问题
        vp_manage.setOffscreenPageLimit(4);
        //设置不可滑动
        vp_manage.setScrollable(true);
        vp_manage.setAdapter(adapter);
        setBackGround(0);
        vp_manage.setCurrentItem(0, false);
    }

    @Override
    protected void initView() {
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_order = (LinearLayout) findViewById(R.id.ll_order);
        ll_shop = (LinearLayout) findViewById(R.id.ll_shop);
        ll_my = (LinearLayout) findViewById(R.id.ll_my);
        ll_home.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_shop.setOnClickListener(this);
        ll_my.setOnClickListener(this);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_order = (ImageView) findViewById(R.id.iv_order);
        iv_shop = (ImageView) findViewById(R.id.iv_shop);
        iv_my = (ImageView) findViewById(R.id.iv_my);
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_order = (TextView) findViewById(R.id.tv_order);
        tv_shop = (TextView) findViewById(R.id.tv_shop);
        tv_my = (TextView) findViewById(R.id.tv_my);
        vp_manage = (AppViewPager) findViewById(R.id.vp_main);
        vp_manage.addOnPageChangeListener(this);
    }

    /**
     * 修改选中背景
     *
     * @param position
     */
    private void setBackGround(int position) {
        iv_home.setImageResource(R.drawable.shouye);
        iv_order.setImageResource(R.drawable.xiadan);
        iv_shop.setImageResource(R.drawable.gouwuche);
        iv_my.setImageResource(R.drawable.wo);
        tv_home.setTextColor(getResources().getColor(R.color.gray_black));
        tv_order.setTextColor(getResources().getColor(R.color.gray_black));
        tv_shop.setTextColor(getResources().getColor(R.color.gray_black));
        tv_my.setTextColor(getResources().getColor(R.color.gray_black));

        if (position == 0) {
            iv_home.setImageResource(R.drawable.shouyeer);
            tv_home.setTextColor(getResources().getColor(R.color.colorTheme));
        } else if (position == 1) {
            iv_order.setImageResource(R.drawable.xiadaner);
            tv_order.setTextColor(getResources().getColor(R.color.colorTheme));
        } else if (position == 2) {
            iv_shop.setImageResource(R.drawable.gouwucheer);
            tv_shop.setTextColor(getResources().getColor(R.color.colorTheme));
        } else if (position == 3) {
            iv_my.setImageResource(R.drawable.woer);
            tv_my.setTextColor(getResources().getColor(R.color.colorTheme));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                vp_manage.setCurrentItem(0, false);
                setBackGround(0);
                break;
            case R.id.ll_order:
                vp_manage.setCurrentItem(1, false);
                setBackGround(1);
                break;
            case R.id.ll_shop:
                vp_manage.setCurrentItem(2, false);
                setBackGround(2);
                break;
            case R.id.ll_my:
                setBackGround(3);
                vp_manage.setCurrentItem(3, false);
                break;
            default:
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setBackGround(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            AppManager.getInstance().finish();
        }
        return false;
    }

}
