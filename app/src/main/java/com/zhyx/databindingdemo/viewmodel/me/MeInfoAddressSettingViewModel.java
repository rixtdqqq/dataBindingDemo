package com.zhyx.databindingdemo.viewmodel.me;

import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.view.activity.me.MeInfoAddressSettingActivity;
import com.zhyx.databindingdemo.view.dialog.EditDropDialog;

/**
 * 设置地址
 *  Created by Administrator on 2018/3/14.
 */

public class MeInfoAddressSettingViewModel {

    private MeInfoAddressSettingActivity mActivity;
    private EditDropDialog mEditDropDialog;

    public MeInfoAddressSettingViewModel(MeInfoAddressSettingActivity activity) {
        mActivity=activity;
    }


    public void setAddress(String name,String phone,String area,String detailAddress,String areaCode) {
        Toast.makeText(App.getAppContext(), "联系人:"+name+"\n手机号码:"+phone+"\n选择地区:"+area+"\n详细地址:"+detailAddress+"\n邮政编码:"+areaCode, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹窗提示：确定要放弃此次编辑？取消、确定
     */
    public void cancelSetAddress() {
        if (mEditDropDialog == null) {
            mEditDropDialog = new EditDropDialog(mActivity, R.style.ActionSheetDialogStyle);
        }
        mEditDropDialog.show();
    }


    /**
     * 跳转到通讯录
     */
    public void jumpToContact() {
        Toast.makeText(App.getAppContext(), "跳转到通讯录", Toast.LENGTH_SHORT).show();
    }



    /**
     * 跳转到通讯录
     */
    public void jumpToLocationActivity() {
        Toast.makeText(App.getAppContext(), "跳转到地图定位", Toast.LENGTH_SHORT).show();
    }


}
