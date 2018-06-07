package com.zhyx.databindingdemo.viewmodel;

import android.content.Intent;

import com.zhyx.databindingdemo.view.activity.MainActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoActivity;
import com.zhyx.databindingdemo.view.activity.settings.MeSettingsActivity;

/**
 * 聊天页面
 * Created by Administrator on 2018/3/14.
 */

public class ChatFragmentViewModel {

    private MainActivity mMainActivity;

    public ChatFragmentViewModel(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    /**
     * 跳转到个人信息页面
     */
    public void jumpToMeInfoActivity() {
        Intent intent = new Intent(mMainActivity, MeInfoActivity.class);
        mMainActivity.startActivity(intent);
    }

    /**
     * 跳转到设置页面
     */
    public void jumpToMeSettingsActivity() {
        Intent intent = new Intent(mMainActivity, MeSettingsActivity.class);
        mMainActivity.startActivity(intent);
    }
}
