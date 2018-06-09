package com.zhyx.databindingdemo.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhyx.databindingdemo.model.OnResultCallBack;
import com.zhyx.databindingdemo.model.entity.ResponseBody;
import com.zhyx.databindingdemo.model.entity.ResponseMessage;
import com.zhyx.databindingdemo.util.HttpUtil;
import com.zhyx.databindingdemo.view.activity.LoginActivity;
import com.zhyx.databindingdemo.view.activity.MainActivity;
import com.zhyx.databindingdemo.view.activity.PasswordForgetActivity;
import com.zhyx.databindingdemo.view.activity.UserRegisterActivity;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        HttpUtil.getInstance().getService().login(userName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody<ResponseMessage>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody<ResponseMessage> responseMessageResponseBody) {
                        ResponseMessage data = responseMessageResponseBody.getData();
                        Toast.makeText(mActivity, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getStatus()==1) {
                            mActivity.startActivity(new Intent(mActivity, MainActivity.class));
                            mActivity.finish();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mActivity, "e="+e, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void registerNewUser() {
        Intent intent = new Intent(mActivity, UserRegisterActivity.class);
        mActivity.startActivity(intent);
    }
    public void forgetPassword() {
        Intent intent = new Intent(mActivity, PasswordForgetActivity.class);
        mActivity.startActivity(intent);
    }
}
