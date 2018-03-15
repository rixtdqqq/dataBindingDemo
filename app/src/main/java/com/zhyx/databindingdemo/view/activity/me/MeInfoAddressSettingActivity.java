package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoAddressSettingBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoAddressSettingViewModel;

public class MeInfoAddressSettingActivity extends BaseActivity{


    private ActivityMeInfoAddressSettingBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_address_setting);
        mBinding.setViewModel(new MeInfoAddressSettingViewModel(this));
    }
}
