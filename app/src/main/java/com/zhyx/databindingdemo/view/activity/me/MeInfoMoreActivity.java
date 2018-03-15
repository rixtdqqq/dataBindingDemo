package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoMoreBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoMoreViewModel;

public class MeInfoMoreActivity extends BaseActivity implements View.OnClickListener{


    private ActivityMeInfoMoreBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_more);
        mBinding.setViewModel(new MeInfoMoreViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
