package com.zhyx.databindingdemo.view.activity.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoPersonalPhotoBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoPersonalPhotoViewModel;

/**
 * 个人头像页面
 */

public class MeInfoPersonalPhotoActivity extends BaseActivity implements View.OnClickListener {


    private ActivityMeInfoPersonalPhotoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_personal_photo);
        mBinding.setViewModel(new MeInfoPersonalPhotoViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
