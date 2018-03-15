package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoAddressBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoAddressViewModel;

public class MeInfoAddressActivity extends BaseActivity implements View.OnClickListener{

private ActivityMeInfoAddressBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_address);
        mBinding.setViewModel(new MeInfoAddressViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
