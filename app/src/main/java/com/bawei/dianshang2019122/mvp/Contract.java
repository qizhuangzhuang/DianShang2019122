package com.bawei.dianshang2019122.mvp;

import com.bawei.dianshang2019122.base.BaseView;
import com.bawei.dianshang2019122.bean.Banner;
import com.bawei.dianshang2019122.bean.BannerBean;
import com.bawei.dianshang2019122.bean.GoodsBean;
import com.bawei.dianshang2019122.bean.GouWuBean;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/5
 *@Time:10:28
 *@Description功能: * */
public interface Contract {
    // TODO: 2019/12/5  写契约类里边的view层
    interface IView extends BaseView{
        // TODO: 2019/12/5  轮播成功方法
        void onBannerSuccess(BannerBean bannerBean);
        // TODO: 2019/12/5  轮播失败方法
        void onBannerError(String msg);

        // TODO: 2019/12/5  展示成功方法
        void onGoodsSuccess(GoodsBean goodsBean);
        // TODO: 2019/12/5  展示失败方法
        void onGoodsError(String msg);

        // TODO: 2019/12/6  购物成功方法
        void onGouWuSuccess(GouWuBean gouWuBean);
        // TODO: 2019/12/6  购物失败方法
        void onGouWuError(String msg);
    }







    // TODO: 2019/12/5  写契约类里边的mode层
    interface IModel{
        void banner(BannerCallBack callBack);

        interface BannerCallBack{
            // TODO: 2019/12/5  轮播成功方法
            void onBannerSuccess(BannerBean bannerBean);
            // TODO: 2019/12/5  轮播失败方法
            void onBannerError(String msg);
        }

        void goods(GoodsCallBack callBack);
        interface GoodsCallBack{
            // TODO: 2019/12/5  展示成功方法
            void onGoodsSuccess(GoodsBean goodsBean);
            // TODO: 2019/12/5  展示失败方法
            void onGoodsError(String msg);
        }

        void gouwu(GouWuCallBack callack);
        interface GouWuCallBack{
            // TODO: 2019/12/6  购物成功方法
            void onGouWuSuccess(GouWuBean gouWuBean);
            // TODO: 2019/12/6  购物失败方法
            void onGouWuError(String msg);
        }
    }





    interface IPresenter{
        // TODO: 2019/12/5  轮播
        void banner();
        // TODO: 2019/12/5  展示
        void goods();
        // TODO: 2019/12/6  购物
        void gouwu();

    }
}
