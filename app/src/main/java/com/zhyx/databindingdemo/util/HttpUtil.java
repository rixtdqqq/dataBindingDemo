package com.zhyx.databindingdemo.util;

import com.zhyx.databindingdemo.model.NetworkService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络请求相关工具类
 * Created by Administrator on 2018/3/20.
 */

public final class HttpUtil {

    private static class HttpUtilSingletonHolder {
        private static final HttpUtil instance = new HttpUtil();
        private static final NetworkService service = NetworkService.Factory.create();
    }

    public static final HttpUtil getInstance() {
        return HttpUtilSingletonHolder.instance;
    }

    private static final NetworkService getService() {
        return HttpUtilSingletonHolder.service;
    }

    private class ComposeThread<T> implements Observable.Transformer<T, T> {
        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }

}
