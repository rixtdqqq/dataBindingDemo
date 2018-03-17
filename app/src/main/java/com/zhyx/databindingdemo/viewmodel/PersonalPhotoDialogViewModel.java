package com.zhyx.databindingdemo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.view.activity.me.MeInfoPersonalPhotoActivity;
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
        Context activityContext = mDialog.getActivityContext();
        if (activityContext instanceof MeInfoPersonalPhotoActivity) {
            MeInfoPersonalPhotoActivity activity = (MeInfoPersonalPhotoActivity) activityContext;
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activity.startActivityForResult(intent, Constant.REQUEST_TAKE_PHOTO);

        }
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
        Context activityContext = mDialog.getActivityContext();
        if (activityContext instanceof MeInfoPersonalPhotoActivity) {
            MeInfoPersonalPhotoActivity activity = (MeInfoPersonalPhotoActivity) activityContext;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            activity.startActivityForResult(intent, Constant.REQUEST_ALBUM);

        }
        mDialog.dismiss();
    }

    /**
     * 取消
     */
    public void dismiss() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "取消", Toast.LENGTH_SHORT).show();
    }

}
