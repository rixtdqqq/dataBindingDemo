package com.zhyx.databindingdemo.model;

import com.zhyx.databindingdemo.util.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络服务
 * Created by Administrator on 2018/3/20.
 */

public interface NetworkService {
    class Factory {
        public static NetworkService create() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)//日志拦截器
                    .addNetworkInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            // TODO: 16/10/20 进行重定向等操作
                            //Interceptor的典型使用场景，就是对request和response的Headers进行编辑
                            return chain.proceed(chain.request());
                        }
                    })//网络拦截器,进行重定向等操作
                    .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时
                    .readTimeout(6,TimeUnit.SECONDS)
                    .writeTimeout(6,TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())//json数据转换
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//将Callable接口转换成Observable接口
                    .client(client)//网络请求客户端为okhttp
                    .build();
            return retrofit.create(NetworkService.class);
        }
    }
}
