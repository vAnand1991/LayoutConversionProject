package com.naxtre.layoutconversionproject;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static MyApplication appContext;
    public static Context getInstance(){
        return  appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.appContext = this;
    }
}
