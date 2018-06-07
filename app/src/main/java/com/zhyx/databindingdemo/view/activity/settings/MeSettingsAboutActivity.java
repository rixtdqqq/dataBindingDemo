package com.zhyx.databindingdemo.view.activity.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeSettingsAboutBinding;
import com.zhyx.databindingdemo.util.JavaMethod;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.settings.MeSettingsAboutViewModel;

public class MeSettingsAboutActivity extends BaseActivity implements View.OnClickListener {

    private ActivityMeSettingsAboutBinding mBinding;
    private JavaMethod javaMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_settings_about);
        mBinding.setViewModel(new MeSettingsAboutViewModel(this));
        mBinding.setNavigationOnClickListener(this);
        javaMethod = new JavaMethod(this);
        WebSettings settings = mBinding.wv.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        mBinding.wv.setWebViewClient(javaMethod.getWebViewClient());
        mBinding.wv.setWebChromeClient(javaMethod.getWebChromeClient());
        mBinding.wv.addJavascriptInterface(javaMethod,"android");
        mBinding.wv.loadUrl("file:///android_asset/demo.html");
        mBinding.loadUrl.setOnClickListener(v->{
            mBinding.wv.loadUrl("javascript:javatojscallback('我来自Java')");
        });
        mBinding.evaluateJS.setOnClickListener(view -> {
            mBinding.wv.evaluateJavascript("javascript:javatojswith('我来自Java')",s -> {
                mBinding.message.setText(s);
            });
        });
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }

    public void setTextShow(String str) {
        mBinding.message.setText(str);
    }
}
