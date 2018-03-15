package com.zhyx.databindingdemo.viewmodel.me;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.view.activity.me.MeInfoCodeActivity;
import com.zhyx.databindingdemo.view.dialog.MeInfoDialog;

/**
 * 我的二维码页面
 * Created by Administrator on 2018/3/14.
 */

public class MeInfoCodeViewModel {

    private MeInfoCodeActivity mActivity;
    private MeInfoDialog dialog;

    public MeInfoCodeViewModel(MeInfoCodeActivity meInfoActivity) {
        mActivity = meInfoActivity;
    }

    public void more() {
        if (dialog == null) {
            dialog = new MeInfoDialog(mActivity, R.style.ActionSheetDialogStyle, Constant.DIALOG_FLAG_MY_CODE);
        }
        dialog.show();
    }



}
