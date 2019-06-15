package com.example.materialtest;

import android.util.Log;

public class LogUtil {

    private static final int VERBOSE=1,DEBAUG=2,INFO=3,WARN=4,ERROR=5,NOTHING=6;

    private static int level=VERBOSE;

    public static void v(String tag,String msg){
        if(level<=VERBOSE){
            Log.v(tag,msg);
        }
    }

    public static void d(String tag,String msg){
        if(level<=DEBAUG){
            Log.d(tag,msg);
        }
    }

    public static void i(String tag,String msg){
        if(level<=INFO){
            Log.i(tag,msg);
        }
    }

    public static void w(String tag,String msg){
        if(level<=WARN){
            Log.w(tag,msg);
        }
    }

    public static void e(String tag,String msg){
        if(level<=ERROR){
            Log.e(tag,msg);
        }
    }

}
