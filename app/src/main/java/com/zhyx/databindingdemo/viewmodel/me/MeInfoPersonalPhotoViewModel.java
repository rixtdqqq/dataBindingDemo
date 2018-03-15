package com.zhyx.databindingdemo.viewmodel.me;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.view.activity.me.MeInfoCodeActivity;
import com.zhyx.databindingdemo.view.activity.me.MeInfoPersonalPhotoActivity;
import com.zhyx.databindingdemo.view.dialog.MeInfoDialog;

/**
 * 个人头像页面
 * Created by Administrator on 2018/3/14.
 */

public class MeInfoPersonalPhotoViewModel {

    private MeInfoPersonalPhotoActivity mActivity;
    private MeInfoDialog dialog;

    public MeInfoPersonalPhotoViewModel(MeInfoPersonalPhotoActivity activity) {
        mActivity = activity;
    }

    public void more() {
        if (dialog == null) {
            dialog = new MeInfoDialog(mActivity, R.style.ActionSheetDialogStyle, Constant.DIALOG_FLAG_PERSONAL_PHOTO);
        }
        dialog.show();
    }



}
