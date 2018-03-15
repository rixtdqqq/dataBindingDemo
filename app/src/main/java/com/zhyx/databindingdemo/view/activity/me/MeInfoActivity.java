package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoViewModel;

public class MeInfoActivity extends BaseActivity implements View.OnClickListener {

    private ActivityMeInfoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info);
        mBinding.setViewModel(new MeInfoViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
