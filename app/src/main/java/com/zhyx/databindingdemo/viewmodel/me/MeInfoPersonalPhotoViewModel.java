package com.zhyx.databindingdemo.viewmodel.me;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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

    @BindingAdapter(value = {"app:placeHolder", "app:error", "app:imageURI", "app:imageBitmap"}, requireAll = false)
    public static void setImageViewSrc(ImageView imageView, Drawable placeHolderResourceId, Drawable errorResourceId, Uri imageUri, Bitmap imageBitmap) {
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions().placeholder(placeHolderResourceId).error(errorResourceId).centerCrop())
                .load(imageBitmap == null ? imageUri : imageBitmap)
                .into(imageView);

    }


}
