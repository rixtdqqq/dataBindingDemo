package com.zhyx.databindingdemo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.util.Constant;
import com.zhyx.databindingdemo.view.activity.me.MeInfoCodeActivity;
import com.zhyx.databindingdemo.view.dialog.MeInfoDialog;

/**
 * 我的二维码页面的弹窗
 * Created by Administrator on 2018/3/14.
 */

public class MyCodeDialogViewModel {

    private MeInfoDialog mDialog;
    private Context mContext;

    public MyCodeDialogViewModel(MeInfoDialog dialog, Context context) {
        mDialog = dialog;
        mContext=context;
    }

    /**
     * 更换样式
     */
    public void changeStyle() {
        Toast.makeText(App.getAppContext(), "更换样式", Toast.LENGTH_SHORT).show();
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
     * 扫描二维码
     */
    public void scanCode() {

        mDialog.dismiss();
        if (mContext instanceof MeInfoCodeActivity) {
            MeInfoCodeActivity activity = (MeInfoCodeActivity) mContext;
            Intent intent = new Intent(activity,CaptureActivity.class);
            activity.startActivityForResult(intent, Constant.REQUEST_BARCODE);
        }


        Toast.makeText(App.getAppContext(), "扫描二维码", Toast.LENGTH_SHORT).show();
    }

    /**
     * 重置二维码
     */
    public void resetCode() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "重置二维码", Toast.LENGTH_SHORT).show();
    }

    /**
     * 取消
     */
    public void dismiss() {

        mDialog.dismiss();
        Toast.makeText(App.getAppContext(), "取消", Toast.LENGTH_SHORT).show();
    }

}
