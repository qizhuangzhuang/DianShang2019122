package com.bawei.dianshang2019122;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.dianshang2019122.fragment.Fragment_Circle;
import com.bawei.dianshang2019122.fragment.Fragment_Home;
import com.bawei.dianshang2019122.fragment.Fragment_Mine;
import com.bawei.dianshang2019122.fragment.Fragment_Order;
import com.bawei.dianshang2019122.fragment.Fragment_Shopping;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.radiobutton1)
    RadioButton mRadiobutton1;
    @BindView(R.id.radiobutton2)
    RadioButton mRadiobutton2;
    @BindView(R.id.radiobutton3)
    RadioButton mRadiobutton3;
    @BindView(R.id.radiobutton4)
    RadioButton mRadiobutton4;
    @BindView(R.id.radiobutton5)
    RadioButton mRadiobutton5;
    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);

        mViewpager = findViewById(R.id.viewpager);
        mRadiogroup = findViewById(R.id.radiogroup);
        mRadiogroup.check(mRadiogroup.getChildAt(0).getId());

        final ArrayList<Fragment> list = new ArrayList<Fragment>();

        Fragment_Home fragment_home = new Fragment_Home();
        Fragment_Circle fragment_circle = new Fragment_Circle();
        Fragment_Shopping fragment_shopping = new Fragment_Shopping();
        Fragment_Order fragment_order = new Fragment_Order();
        Fragment_Mine fragment_mine = new Fragment_Mine();

        list.add(fragment_home);
        list.add(fragment_circle);
        list.add(fragment_shopping);
        list.add(fragment_order);
        list.add(fragment_mine);

        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mRadiogroup.check(mRadiogroup.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radiobutton1:
                        mViewpager.setCurrentItem(0);
                        break;
                    case R.id.radiobutton2:
                        mViewpager.setCurrentItem(1);
                        break;
                    case R.id.radiobutton3:
                        mViewpager.setCurrentItem(2);
                        break;
                    case R.id.radiobutton4:
                        mViewpager.setCurrentItem(3);
                        break;
                    case R.id.radiobutton5:
                        mViewpager.setCurrentItem(4);
                        break;


                        default:
                            break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
