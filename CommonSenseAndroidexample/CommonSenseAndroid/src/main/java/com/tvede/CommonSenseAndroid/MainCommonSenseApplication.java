package com.tvede.CommonSenseAndroid;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by kasper on 21-08-2016.
 */

public class MainCommonSenseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
