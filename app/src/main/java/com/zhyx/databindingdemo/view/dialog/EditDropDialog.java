package com.zhyx.databindingdemo.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.DialogDropEditBinding;
import com.zhyx.databindingdemo.view.activity.me.MeInfoAddressSettingActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoNameSettingActivity;

/**
 * 确定、取消放弃编辑的弹窗
 * Created by Administrator on 2018/3/16.
 */

public class EditDropDialog extends Dialog {

    private Context mContext;

    public EditDropDialog(@NonNull Context context) {
        super(context);
        mContext=context;
    }

    public EditDropDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
    }

    protected EditDropDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogDropEditBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.dialog_drop_edit, null, false);
        setContentView(binding.getRoot());
        binding.setDialog(this);
        setDialogStyle();
    }

    private void setDialogStyle() {
        Window window = getWindow();
        if (null != window) {
            WindowManager windowManager = window.getWindowManager();
            Display defaultDisplay = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (defaultDisplay.getWidth()*0.8);
            window.setAttributes(attributes);
        }
    }

    public void confirm() {
        if (mContext instanceof MeInfoAddressSettingActivity) {
            MeInfoAddressSettingActivity activity = (MeInfoAddressSettingActivity) mContext;
            activity.finish();
        } else if (mContext instanceof MeInfoNameSettingActivity) {
            MeInfoNameSettingActivity activity = (MeInfoNameSettingActivity) mContext;
            activity.finish();
        }
    }
}
