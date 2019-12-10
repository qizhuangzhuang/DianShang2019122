package com.bawei.dianshang2019122.mvp;

import com.bawei.dianshang2019122.bean.Banner;
import com.bawei.dianshang2019122.bean.BannerBean;
import com.bawei.dianshang2019122.bean.GoodsBean;
import com.bawei.dianshang2019122.bean.GouWuBean;
import com.bawei.dianshang2019122.net.ApiService;
import com.bawei.dianshang2019122.net.HttpUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/*
 *@Auther:祁壮壮
 *@Date: 2019/12/5
 *@Time:10:35
 *@Description功能: * */
public class ModeImpl implements Contract.IModel{

    @Override
    public void banner(final BannerCallBack callBack) {
        ApiService apiService = HttpUtil.getInstance().getRetrofit().create(ApiService.class);
        Observable<BannerBean> observable = apiService.bannerBean();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // TODO: 2019/12/6  请求前

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        // TODO: 2019/12/6  请求结果
                        callBack.onBannerSuccess(bannerBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 2019/12/6  请求异常
                        callBack.onBannerError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        // TODO: 2019/12/6  请求结束

                    }
                });
    }

    @Override
    public void goods(final GoodsCallBack callBack) {
        ApiService apiService = HttpUtil.getInstance().getRetrofit().create(ApiService.class);
        Observable<GoodsBean> observable = apiService.goodsBean();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // TODO: 2019/12/6  请求前

                    }

                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        // TODO: 2019/12/6  请求结果
                        callBack.onGoodsSuccess(goodsBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 2019/12/6  请求异常
                        callBack.onGoodsError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        // TODO: 2019/12/6  请求结束

                    }
                });

    }

    @Override
    public void gouwu(final GouWuCallBack callack) {
        ApiService apiService = HttpUtil.getInstance().getRetrofit().create(ApiService.class);
        Observable<GouWuBean> observable = apiService.gouwuBean();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GouWuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // TODO: 2019/12/6  请求前
                    }

                    @Override
                    public void onNext(GouWuBean gouWuBean) {
                        // TODO: 2019/12/6  请求结果
                        callack.onGouWuSuccess(gouWuBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 2019/12/6  请求异常
                        callack.onGouWuError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        // TODO: 2019/12/6  请求结束

                    }
                });

    }
}
