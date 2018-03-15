package com.zhyx.databindingdemo.viewmodel;

import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.view.dialog.MeInfoDialog;

/**
 * 个人头像页面的弹窗
 * Created by Administrator on 2018/3/14.
 */

public class PersonalPhotoDialogViewModel {

    private MeInfoDialog mDialog;

    public PersonalPhotoDialogViewModel(MeInfoDialog dialog) {
        mDialog = dialog;
    }

    /**
     * 拍照
     */
    public void takePhoto() {
        Toast.makeText(App.getAppContext(), "拍照", Toast.LENGTH_SHORT).show();
        mDialog.dismiss();
    }

    /**
     * 保存图片
     */
    public void savePic() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "保存图片", Toast.LENGTH_SHORT).show();
    }

    /**
     * 从手机相册选择
     */
    public void selectPhoto() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "从手机相册选择", Toast.LENGTH_SHORT).show();
    }

    /**
     * 取消
     */
    public void dismiss() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "取消", Toast.LENGTH_SHORT).show();
    }

}
