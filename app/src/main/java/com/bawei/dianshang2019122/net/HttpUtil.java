package com.bawei.dianshang2019122.net;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/2
 *@Time:9:18
 *@Description功能: * */
public class HttpUtil {
    private final Retrofit retrofit;

    private static class UtilHolder{
        private static HttpUtil util = new HttpUtil();

    }

    private HttpUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/small/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        if (message.startsWith("{") || message.startsWith("[")){
                            Logger.json(message);
                        }else {
                            Logger.d(message);
                        }
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY)).build()).build();
    }

    public static HttpUtil getInstance(){
        return UtilHolder.util;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

}
