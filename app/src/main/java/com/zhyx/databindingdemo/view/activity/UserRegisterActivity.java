package com.zhyx.databindingdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityUserRegisterBinding;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.UserRegisterActivityViewModel;

public class UserRegisterActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ActivityUserRegisterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_register);
        mBinding.setViewModel(new UserRegisterActivityViewModel(this,mBinding));
        mBinding.setNavigationOnClickListener(this);
        mBinding.setOnCheckedChangeListener(this);
        mBinding.setGender(1);//默认为男
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.gender_male:
                mBinding.setGender(1);
                break;
            case R.id.gender_female:
                mBinding.setGender(0);
                break;
            case R.id.gender_secret:
                mBinding.setGender(2);
                break;
        }
    }
}
