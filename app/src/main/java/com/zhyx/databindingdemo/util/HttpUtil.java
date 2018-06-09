package com.zhyx.databindingdemo.util;

import com.zhyx.databindingdemo.model.NetworkService;

/**
 * 网络请求相关工具类
 * Created by Administrator on 2018/3/20.
 */

public final class HttpUtil {

    private static class HttpUtilSingletonHolder {
        private static final HttpUtil instance = new HttpUtil();
        private static final NetworkService service = NetworkService.Factory.create();
    }

    public static HttpUtil getInstance() {
        return HttpUtilSingletonHolder.instance;
    }

    public  NetworkService getService() {
        return HttpUtilSingletonHolder.service;
    }


}
