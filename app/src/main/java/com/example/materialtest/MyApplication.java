package com.example.materialtest;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
