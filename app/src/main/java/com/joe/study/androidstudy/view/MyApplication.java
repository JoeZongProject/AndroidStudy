package com.joe.study.androidstudy.view;

import android.app.Application;

import com.tencent.bugly.Bugly;

/**
 * @Author zongdongdong on 2017/11/3.
 * {@link }
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "c38e49c29d", false);
    }
}
