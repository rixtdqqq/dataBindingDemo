package com.zhyx.databindingdemo.view.activity.me;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoCodeBinding;
import com.zhyx.databindingdemo.util.Constant;
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
        mBinding.setViewModel(new MeInfoCodeViewModel(this,mBinding));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_BARCODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (null == bundle) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析结果失败，请重试.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
