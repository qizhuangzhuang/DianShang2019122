package com.bawei.dianshang2019122.net;

import com.bawei.dianshang2019122.bean.Banner;
import com.bawei.dianshang2019122.bean.BannerBean;
import com.bawei.dianshang2019122.bean.GoodsBean;
import com.bawei.dianshang2019122.bean.GouWuBean;
import com.bawei.dianshang2019122.bean.HomeGoods;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/4
 *@Time:8:56
 *@Description功能: * */
public interface ApiService {
    // TODO: 2019/12/4  banner展示
    @GET(Link.BANNER_URL)
    Observable<BannerBean> bannerBean();

    // TODO: 2019/12/4  多条目展示
    @GET(Link.GOODS_URL)
    Observable<GoodsBean> goodsBean();

    // TODO: 2019/12/6  购物车展示
    @GET(Link.GOUWU_URL)
    @Headers({"userId:10922","sessionId:157563116305510922"})
    Observable<GouWuBean> gouwuBean();

}
