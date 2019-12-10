package com.bawei.dianshang2019122.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/4
 *@Time:14:11
 *@Description功能: * */
public class HeardInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        // TODO: 2019/12/4  从拦截器获取请求对象
        Request request = chain.request();
        // TODO: 2019/12/4  获取请求对象的builder对象
        Request.Builder builder = request.newBuilder();
        // TODO: 2019/12/4  通过builder添加请求头
        builder.header("userId","10922");
        builder.header("sessionId","157559325456410922");
        // TODO: 2019/12/4  通过builder构建新的builder对象
        Request newRequest = builder.build();
        // TODO: 2019/12/4  通过拦截器获取请求结果
        Response response = chain.proceed(newRequest);
        // TODO: 2019/12/4  返回response
        return response;


    }
}
