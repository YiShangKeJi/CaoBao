package com.ys.caobao.util;

import android.app.Activity;
import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

/**
 * 必须注册才能使用
 */
public class AppManager extends Application {
    private List<Activity> activities = new ArrayList<Activity>();
    private static AppManager instance;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "c2daa7ccaf", false);
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                instance = new AppManager();
            }
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void finish() {
        for (Activity act : activities) {
            act.finish();
        }
        System.exit(0);
    }

}