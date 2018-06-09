package com.zhyx.databindingdemo.model;

import com.zhyx.databindingdemo.model.entity.ResponseBody;
import com.zhyx.databindingdemo.model.entity.ResponseMessage;
import com.zhyx.databindingdemo.util.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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
                    .addNetworkInterceptor(chain -> chain.proceed(chain.request()))//网络拦截器,进行重定向等操作
                    .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时
                    .readTimeout(6, TimeUnit.SECONDS)
                    .writeTimeout(6, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(client)//网络请求客户端为okhttp
                    .addConverterFactory(GsonConverterFactory.create())//json数据转换
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//将Callable接口转换成Observable接口
                    .build();
            return retrofit.create(NetworkService.class);
        }
    }

    @FormUrlEncoded
    @POST("LoginServlet")
    Observable<ResponseBody<ResponseMessage>>  login(@Field("userName") String name, @Field("password") String password);
}
