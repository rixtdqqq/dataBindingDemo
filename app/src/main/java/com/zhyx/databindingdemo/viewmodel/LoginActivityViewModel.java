package com.zhyx.databindingdemo.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhyx.databindingdemo.view.activity.LoginActivity;
import com.zhyx.databindingdemo.view.activity.MainActivity;
import com.zhyx.databindingdemo.view.activity.UserRegisterActivity;

/**
 * 登录页面
 * Created by Administrator on 2018/1/27.
 */

public class LoginActivityViewModel {

    private LoginActivity mActivity;

    public LoginActivityViewModel(LoginActivity activity) {
        mActivity = activity;
    }

    public void login(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(mActivity, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(mActivity, MainActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }

    public void registerNewUser() {
        Intent intent = new Intent(mActivity, UserRegisterActivity.class);
        mActivity.startActivity(intent);
    }
    public void forgetPassword() {
        Toast.makeText(mActivity, "忘记密码.", Toast.LENGTH_SHORT).show();
    }
}
