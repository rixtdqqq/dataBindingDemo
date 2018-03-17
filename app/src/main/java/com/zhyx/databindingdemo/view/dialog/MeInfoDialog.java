package com.zhyx.databindingdemo.view.dialog;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Window;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.DialogMeInfoBinding;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.viewmodel.MyCodeDialogViewModel;
import com.zhyx.databindingdemo.viewmodel.PersonalPhotoDialogViewModel;

/**
 * 我的二维码页面的弹窗
 * Created by Administrator on 2018/3/14.
 */

public class MeInfoDialog extends android.app.Dialog {

    private Context mContext;
    private String mDialogFlag = "";

    public MeInfoDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public MeInfoDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    public MeInfoDialog(@NonNull Context context, int themeResId, String dialogFlag) {
        super(context, themeResId);
        mContext = context;
        mDialogFlag = dialogFlag;
    }

    protected MeInfoDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    public Context getActivityContext() {
        return mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogMeInfoBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_me_info, null, false);
        setContentView(binding.getRoot());
        if (TextUtils.equals(mDialogFlag, Constant.DIALOG_FLAG_MY_CODE)) {//从我的二维码页面过来
            binding.setMyCodeViewModel(new MyCodeDialogViewModel(this));
            binding.setIsFromMyCode(true);
        } else if (TextUtils.equals(mDialogFlag, Constant.DIALOG_FLAG_PERSONAL_PHOTO)) {//从个人头像页面过来
            binding.setPersonalPhotoViewModel(new PersonalPhotoDialogViewModel(this));
            binding.setIsFromMyCode(false);
        }
        setDialogStyle();
    }

    private void setDialogStyle() {
        Window window = getWindow();
        if (null != window) {
            window.setGravity(Gravity.BOTTOM);
            window.setBackgroundDrawable(new BitmapDrawable());
        }
    }

}
