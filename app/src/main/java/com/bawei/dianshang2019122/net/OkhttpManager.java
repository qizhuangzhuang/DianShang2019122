package com.bawei.dianshang2019122.net;

import android.os.Handler;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/4
 *@Time:14:19
 *@Description功能: * */
public class OkhttpManager {
    // TODO: 2019/12/4  声明一个静态实例
    public static OkhttpManager instance = new OkhttpManager();
    private OkHttpClient okHttpClient;
    private Handler handler = new Handler();

    // TODO: 2019/12/4  构造方法私有化
    private OkhttpManager() {
        okHttpClient = new OkHttpClient.Builder()
                // TODO: 2019/12/4  设置读取时间
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                // TODO: 2019/12/4  设置写入时间
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                // TODO: 2019/12/4  设置连接超时时间
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                // TODO: 2019/12/5  添加拦截器请求头
                .addInterceptor(new HeardInterceptor())
                // TODO: 2019/12/5  http日志拦截器
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        if (message.startsWith("{") || message.startsWith("[")) {
                            Logger.json(message);
                        } else {
                            Logger.d(message);
                        }
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY)).build();//打印级别为body

    }

    // TODO: 2019/12/5  暴露一个静态的getinstance方法
    public static OkhttpManager getInstance() {
        return instance;
    }

    // TODO: 2019/12/4  暴露get方法
    public void doGet(String path, final DataCallBack callBack) {
        // TODO: 2019/12/4  默认就是get请求
        Request.Builder builder = new Request.Builder();
        builder.url(path);
        Request request = builder.build();
        // TODO: 2019/12/4  返回一个call对象，okhttp把每次请求都封装成一个call对象
        Call call = okHttpClient.newCall(request);
        // TODO: 2019/12/4  执行异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // TODO: 2019/12/4  请求失败的回调，回调是在子线程中
                final String message = e.getMessage();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 2019/12/5  失败
                        callBack.onFailure(message);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // TODO: 2019/12/4  请求成功的回调，会掉在子线程中
                // TODO: 2019/12/4  获取json数据
                ResponseBody body = response.body();
                final String json = body.string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 2019/12/5  成功
                        callBack.onSuccess(json);
                    }
                });
            }
        });
    }

    // TODO: 2019/12/4  暴露dopost方法，post普通表单
    public void doPost(String path, Map<String, String> params, final DataCallBack callBack) {
        // TODO: 2019/12/4  创建request.builder
        Request.Builder builder = new Request.Builder();
        builder.url(path);

        FormBody.Builder form = new FormBody.Builder();
        // TODO: 2019/12/4  遍历map，获取map中所有key和value
        Set<Map.Entry<String, String>> entrySet = params.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            // TODO: 2019/12/4  把key和value加入到表单中
            form.add(key, value);

        }
        FormBody body = form.build();
        builder.post(body);

        Request request = builder.build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                final String message = e.getMessage();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailure(message);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                final String json = responseBody.string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(json);
                    }
                });
            }
        });
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    // TODO: 2019/12/4  暴露一个接口
    public interface DataCallBack {
        // TODO: 2019/12/4  成功
        void onSuccess(String data);

        // TODO: 2019/12/4  失败
        void onFailure(String msg);
    }
}
