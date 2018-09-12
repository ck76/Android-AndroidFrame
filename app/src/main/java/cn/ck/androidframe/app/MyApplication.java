package cn.ck.androidframe.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import cn.ck.androidframe.BuildConfig;

/**
 * Created by ck on 2018/9/13.
 */
public class MyApplication extends Application {
    public static Context AppContext;
    public static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        application = this;


        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }
}
