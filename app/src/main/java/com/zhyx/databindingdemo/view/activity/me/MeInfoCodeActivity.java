package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoCodeBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoCodeViewModel;

/**
 * 我的二维码页面
 */

public class MeInfoCodeActivity extends BaseActivity implements View.OnClickListener {


    private ActivityMeInfoCodeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_code);
        mBinding.setViewModel(new MeInfoCodeViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
