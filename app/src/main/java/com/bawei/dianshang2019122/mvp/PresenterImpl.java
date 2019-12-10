package com.bawei.dianshang2019122.mvp;

import com.bawei.dianshang2019122.base.BasePresenter;
import com.bawei.dianshang2019122.bean.Banner;
import com.bawei.dianshang2019122.bean.BannerBean;
import com.bawei.dianshang2019122.bean.GoodsBean;
import com.bawei.dianshang2019122.bean.GouWuBean;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/5
 *@Time:10:51
 *@Description功能: * */
public class PresenterImpl extends BasePresenter<Contract.IView> implements Contract.IPresenter{

    private ModeImpl mode;

    @Override
    protected void initModel() {
        mode = new ModeImpl();

    }

    @Override
    public void banner() {
        mode.banner(new Contract.IModel.BannerCallBack() {
            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(String msg) {
                getView().onBannerError(msg);

            }
        });

    }

    @Override
    public void goods() {
        mode.goods(new Contract.IModel.GoodsCallBack() {
            @Override
            public void onGoodsSuccess(GoodsBean goodsBean) {
                getView().onGoodsSuccess(goodsBean);
            }

            @Override
            public void onGoodsError(String msg) {
                getView().onGoodsError(msg);

            }
        });

    }

    @Override
    public void gouwu() {
        mode.gouwu(new Contract.IModel.GouWuCallBack() {
            @Override
            public void onGouWuSuccess(GouWuBean gouWuBean) {
                getView().onGouWuSuccess(gouWuBean);
            }

            @Override
            public void onGouWuError(String msg) {

            }
        });

    }
}
