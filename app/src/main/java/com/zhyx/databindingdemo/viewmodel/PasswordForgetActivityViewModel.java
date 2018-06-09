package com.zhyx.databindingdemo.viewmodel;

import android.widget.Toast;

import com.zhyx.databindingdemo.view.activity.PasswordForgetActivity;

/**
 * 登录页面
 * Created by Administrator on 2018/1/27.
 */

public class PasswordForgetActivityViewModel {

    private PasswordForgetActivity mActivity;

    public PasswordForgetActivityViewModel(PasswordForgetActivity activity) {
        mActivity = activity;
    }

    public void sendCheckCode(String account, String email) {
        Toast.makeText(mActivity, "account=" + account + "\nemail=" + email, Toast.LENGTH_SHORT).show();
    }
}
