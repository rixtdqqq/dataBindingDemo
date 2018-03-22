package com.zhyx.databindingdemo.viewmodel.me;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoCodeBinding;
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
    private ActivityMeInfoCodeBinding mBinding;

    public MeInfoCodeViewModel(MeInfoCodeActivity meInfoActivity, ActivityMeInfoCodeBinding binding) {
        mActivity = meInfoActivity;
        mBinding=binding;
        generateQRCode();
    }

    public void more() {
        if (dialog == null) {
            dialog = new MeInfoDialog(mActivity, R.style.ActionSheetDialogStyle, Constant.DIALOG_FLAG_MY_CODE);
        }
        dialog.show();
    }

    private void generateQRCode() {
        Bitmap bitmap = CodeUtils.createImage(mBinding.codeNickname.getText().toString() + mBinding.codeAddress.getText().toString(),
                400, 400,
                BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.ic_person_black_24dp));
        if (null != bitmap) {
            mBinding.codeIv.setImageBitmap(bitmap);
        }
    }



}
