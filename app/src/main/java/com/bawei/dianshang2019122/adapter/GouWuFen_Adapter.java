package com.bawei.dianshang2019122.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dianshang2019122.Asease;
import com.bawei.dianshang2019122.R;
import com.bawei.dianshang2019122.bean.GouWuBean;
import com.bumptech.glide.Glide;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class GouWuFen_Adapter extends RecyclerView.Adapter<GouWuFen_Adapter.ViewHolder> {
    public   List<GouWuBean.ResultBean.ShoppingCartListBean> list=new ArrayList<>();
    public Context context;

    public GouWuFen_Adapter(List<GouWuBean.ResultBean.ShoppingCartListBean> list, Context context) {
        this.list.addAll(list);
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gouwu_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final GouWuBean.ResultBean.ShoppingCartListBean gouWuDataBean = list.get(i);
        viewHolder.gouwu_item_name.setText(gouWuDataBean.getCommodityName());
        Glide.with(context).load(gouWuDataBean.getPic()).into(viewHolder.gouwu_item_imgs);
        viewHolder.gouwu_item_price.setText(gouWuDataBean.getPrice()+"");
        boolean checked = gouWuDataBean.isChecked();
        viewHolder.gouwu_item_chenckbox.setChecked(checked);

        int count = gouWuDataBean.getCount();
        viewHolder.addView.setNum(count);


        viewHolder.addView.setDataCallBack(new Asease.DataCallBack() {
            @Override
            public void back(int numa) {
                gouWuDataBean.setCount(numa);
                EventBus.getDefault().post(new EventBean());


            }
        });

        viewHolder.gouwu_item_chenckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked1 = viewHolder.gouwu_item_chenckbox.isChecked();
                gouWuDataBean.setChecked(checked1);
                EventBus.getDefault().post(new EventBean());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public Asease addView;
        public CheckBox gouwu_item_chenckbox;
        public ImageView gouwu_item_imgs;
        public TextView gouwu_item_name;
        public TextView gouwu_item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addView = (Asease) itemView.findViewById(R.id.addView);
            gouwu_item_imgs = (ImageView) itemView.findViewById(R.id.gouwu_item_imgs);
            gouwu_item_name = (TextView) itemView.findViewById(R.id.gouwu_item_name);
            gouwu_item_price = (TextView) itemView.findViewById(R.id.gouwu_item_price);
            gouwu_item_chenckbox = (CheckBox) itemView.findViewById(R.id.gouwu_item_chenckbox);
        }
    }
}
