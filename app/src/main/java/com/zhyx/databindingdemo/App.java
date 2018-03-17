package com.zhyx.databindingdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.zhyx.databindingdemo.model.DaoMaster;

import org.greenrobot.greendao.AbstractDaoMaster;

/**
 * 程序 入口 ，做一些第三方框架 的初始化
 *  Created by Administrator on 2018/1/27.
 */

public class App extends Application implements Application.ActivityLifecycleCallbacks {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initDao();
        //作用:可以得到所有的activity，包括第三方框架中的
        registerActivityLifecycleCallbacks(this);
    }


    public static Context getAppContext(){
        return mContext;
    }

    /**
     * 初始化数据库框架
     */
    private void initDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "dataBinding.db");


    }







    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.e("APP--onActivityCreated", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e("APP--onActivityStarted", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.e("APP--onActivityCreated", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e("APP--onActivityResumed", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e("APP--onActivityStopped", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.e("APP--saveInstanceState", activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e("APP--onActivityDestroy", activity.getClass().getSimpleName());
    }
}
