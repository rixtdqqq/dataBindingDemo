package com.zhyx.databindingdemo.viewmodel.settings;

import android.content.Intent;

import com.zhyx.databindingdemo.view.activity.me.MeInfoActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoAddressActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoCodeActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoMoreActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoNameSettingActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoPersonalPhotoActivity;
import com.zhyx.databindingdemo.view.activity.settings.MeSettingsActivity;

/**
 * 个人信息
 * Created by Administrator on 2018/3/14.
 */

public class MeSettingsViewModel {

    private MeSettingsActivity mMeInfoActivity;

    public MeSettingsViewModel(MeSettingsActivity meInfoActivity) {
        mMeInfoActivity = meInfoActivity;
    }

    /**
     * 跳转到设置名字页面
     */
    public void jumpToNameSettingActivity() {
        Intent intent = new Intent(mMeInfoActivity, MeInfoNameSettingActivity.class);
        mMeInfoActivity.startActivity(intent);
    }

    /**
     * 跳转到个人头像页面
     */
    public void jumpToPersonalPhotoActivity() {
        Intent intent = new Intent(mMeInfoActivity, MeInfoPersonalPhotoActivity.class);
        mMeInfoActivity.startActivity(intent);
    }

    /**
     * 跳转到我的二维码页面
     */
    public void jumpToMeInfoCodeActivity() {
        Intent intent = new Intent(mMeInfoActivity, MeInfoCodeActivity.class);
        mMeInfoActivity.startActivity(intent);
    }

    /**
     * 跳转到个人信息的更多页面
     */
    public void jumpToMeInfoMoreActivity() {
        Intent intent = new Intent(mMeInfoActivity, MeInfoMoreActivity.class);
        mMeInfoActivity.startActivity(intent);
    }

    /**
     * 跳转到个人信息的我的地址页面
     */
    public void jumpToMeInfoAddressActivity() {
        Intent intent = new Intent(mMeInfoActivity, MeInfoAddressActivity.class);
        mMeInfoActivity.startActivity(intent);
    }
}
