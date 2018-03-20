package com.zhyx.databindingdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityLoginBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.LoginActivityViewModel;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mBinding.setViewModel(new LoginActivityViewModel(this));
    }
}
