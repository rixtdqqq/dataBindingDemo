package com.zhyx.databindingdemo.model;

public interface OnResultCallBack {
    void onSuccess(Object result);

    void onFail(String errorMsg);
}
