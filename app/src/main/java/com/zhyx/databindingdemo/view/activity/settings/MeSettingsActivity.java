package com.zhyx.databindingdemo.view.activity.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeSettingsBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.settings.MeSettingsViewModel;

public class MeSettingsActivity extends BaseActivity implements View.OnClickListener {

    private ActivityMeSettingsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_settings);
        mBinding.setViewModel(new MeSettingsViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
