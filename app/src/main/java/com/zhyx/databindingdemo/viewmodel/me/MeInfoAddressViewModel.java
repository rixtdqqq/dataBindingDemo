package com.zhyx.databindingdemo.viewmodel.me;

import android.content.Intent;

import com.zhyx.databindingdemo.view.activity.me.MeInfoAddressActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoAddressSettingActivity;

/**
 * 个人信息
 *  Created by Administrator on 2018/3/14.
 */

public class MeInfoAddressViewModel {

    private MeInfoAddressActivity mMeInfoAddressActivity;

    private boolean hasData;

    public MeInfoAddressViewModel(MeInfoAddressActivity activity) {
        mMeInfoAddressActivity=activity;
    }

    public boolean isHasData() {
        return hasData;
    }

    public void setHasData(boolean hasData) {
        this.hasData = hasData;
    }

    /**
     * 跳转到设置地址页面
     */
    public void jumpToAddressSettingActivity() {
        Intent intent = new Intent(mMeInfoAddressActivity, MeInfoAddressSettingActivity.class);
        mMeInfoAddressActivity.startActivity(intent);
    }

}
