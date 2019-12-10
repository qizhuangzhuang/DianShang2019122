package com.bawei.dianshang2019122.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dianshang2019122.R;
import com.bawei.dianshang2019122.base.BaseFragment;
import com.bawei.dianshang2019122.base.BasePresenter;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/2
 *@Time:8:58
 *@Description功能: * */
// TODO: 2019/12/2  直接继承BaseFragment
public class Fragment_Home extends BaseFragment {


    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected BasePresenter initPresnet() {
        return null;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
