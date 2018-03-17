package com.zhyx.databindingdemo.view.activity.me;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMeInfoPersonalPhotoBinding;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.view.base.BaseActivity;
import com.zhyx.databindingdemo.viewmodel.me.MeInfoPersonalPhotoViewModel;

/**
 * 个人头像页面
 */

public class MeInfoPersonalPhotoActivity extends BaseActivity implements View.OnClickListener {


    private ActivityMeInfoPersonalPhotoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_me_info_personal_photo);
        mBinding.setViewModel(new MeInfoPersonalPhotoViewModel(this));
        mBinding.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.REQUEST_ALBUM://从手机相册返回
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "未选择相片", Toast.LENGTH_SHORT).show();
                    return;
                }
                Uri uri = data.getData();
                mBinding.setImageUri(uri);
                break;
            case Constant.REQUEST_TAKE_PHOTO:
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "取消拍照", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bitmap bitmap = data.getParcelableExtra("data");
                mBinding.setImageBitmap(bitmap);
                break;
        }

    }
}
