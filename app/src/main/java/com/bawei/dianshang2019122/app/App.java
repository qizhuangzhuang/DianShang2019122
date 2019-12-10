package com.bawei.dianshang2019122.app;

import android.app.Application;
import android.content.Context;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/2
 *@Time:9:18
 *@Description功能: * */
// TODO: 2019/12/5  初始化
public class App extends Application {
    // TODO: 2019/12/5  暴露一个静态上下文
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
