package com.zhyx.databindingdemo.viewmodel.me;

import android.databinding.BindingAdapter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.view.activity.me.MeInfoNameSettingActivity;
import com.zhyx.databindingdemo.view.dialog.EditDropDialog;

/**
 * 设置名字
 * Created by Administrator on 23/14.
 */

public class MeInfoNameSettingViewModel {

    private MeInfoNameSettingActivity mActivity;
    private EditDropDialog mEditDropDialog;

    public MeInfoNameSettingViewModel(MeInfoNameSettingActivity activity) {
        mActivity = activity;
    }

    @BindingAdapter(value = {"android:textChangedListener"}, requireAll = false)
    public static void addTextChangedListener(EditText editText, TextWatcher watcher) {
        editText.addTextChangedListener(watcher);
    }


    /**
     * 弹窗提示：确定要放弃此次编辑？取消、确定
     */
    public void cancelSetName() {
        if (mEditDropDialog == null) {
            mEditDropDialog = new EditDropDialog(mActivity, R.style.ActionSheetDialogStyle);
        }
        mEditDropDialog.show();
    }


    /**
     * 完成
     */
    public void submit(String content) {
        Toast.makeText(App.getAppContext(), content, Toast.LENGTH_SHORT).show();
    }


    /**
     * 清除文本
     */
    public void clearText(EditText editText) {
        editText.setText("");
    }


}
