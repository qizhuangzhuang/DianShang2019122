package com.bawei.dianshang2019122.base;

import java.lang.ref.WeakReference;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/2
 *@Time:9:23
 *@Description功能: * */
public abstract class BasePresenter<V extends BaseView> {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    //与视图连接
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    //与视图分开
    public void detch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    //返回view
    public V getView(){
        V v1 = weakReference.get();
        return v1;
    }


}
