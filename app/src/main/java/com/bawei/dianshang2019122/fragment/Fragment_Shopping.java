package com.bawei.dianshang2019122.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.dianshang2019122.R;
import com.bawei.dianshang2019122.adapter.EventBean;
import com.bawei.dianshang2019122.adapter.GouWuAdapter;
import com.bawei.dianshang2019122.base.BaseFragment;
import com.bawei.dianshang2019122.bean.BannerBean;
import com.bawei.dianshang2019122.bean.GoodsBean;
import com.bawei.dianshang2019122.bean.GouWuBean;
import com.bawei.dianshang2019122.mvp.Contract;
import com.bawei.dianshang2019122.mvp.PresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/2
 *@Time:9:01
 *@Description功能: * */
public class Fragment_Shopping extends BaseFragment<PresenterImpl> implements Contract.IView {


    private RecyclerView gouwu_recycles;
    private CheckBox gouwu_zong_chengckbox;
    private TextView heji_price;
    private TextView tijiao_nums;
    private GouWuAdapter gouWuAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        gouwu_recycles = (RecyclerView) view.findViewById(R.id.gouwu_recycles);
        gouwu_zong_chengckbox = (CheckBox) view.findViewById(R.id.gouwu_zong_chengckbox);
        heji_price = (TextView) view.findViewById(R.id.heji_price);
        tijiao_nums = (TextView) view.findViewById(R.id.tijiao_nums);

    }

    @Override
    protected PresenterImpl initPresnet() {
        return new PresenterImpl();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presents.gouwu();
        gouwu_zong_chengckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = gouwu_zong_chengckbox.isChecked();
                gouWuAdapter.setChecked(checked);
                toPrice();
            }
        });
    }
    @Subscribe
    public void JieShou(EventBean eventBean){
        toPrice();
    }

    private void toPrice() {
        double tob=0;
        List<GouWuBean.ResultBean> list = gouWuAdapter.getList();
        for (int i=0;i<list.size();i++){
            GouWuBean.ResultBean gouWuListBean = list.get(i);
            List<GouWuBean.ResultBean.ShoppingCartListBean> shoppingCartList = gouWuListBean.getShoppingCartList();
            for (int j=0;j<shoppingCartList.size();j++){

                GouWuBean.ResultBean.ShoppingCartListBean gouWuDataBean = shoppingCartList.get(j);
                if (gouWuDataBean.isChecked()) {
                    int count = gouWuDataBean.getCount();
                    double price = gouWuDataBean.getPrice();
                    double temp = count * price;
                    tob += temp;
                }
            }
        }
        heji_price.setText(tob+"");

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

    }

    @Override
    public void onBannerError(String msg) {

    }

    @Override
    public void onGoodsSuccess(GoodsBean goodsBean) {

    }

    @Override
    public void onGoodsError(String msg) {

    }

    @Override
    public void onGouWuSuccess(GouWuBean gouWuBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gouwu_recycles.setLayoutManager(linearLayoutManager);
        List<GouWuBean.ResultBean> result = gouWuBean.getResult();
        gouWuAdapter = new GouWuAdapter(result, getContext());
        gouwu_recycles.setAdapter(gouWuAdapter);

    }

    @Override
    public void onGouWuError(String msg) {

    }
}
