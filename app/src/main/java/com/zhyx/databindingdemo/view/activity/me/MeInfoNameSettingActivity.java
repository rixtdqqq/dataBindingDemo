package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoNameSettingBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoNameSettingViewModel;

public class MeInfoNameSettingActivity extends BaseActivity implements TextWatcher {

    private ActivityMeInfoNameSettingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_name_setting);
        mBinding.setViewModel(new MeInfoNameSettingViewModel(this));
        mBinding.setTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mBinding.setIsShow(charSequence != null && charSequence.length() > 0);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
