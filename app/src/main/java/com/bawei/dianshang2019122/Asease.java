package com.bawei.dianshang2019122;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshang2019122.net.OkhttpManager;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/6
 *@Time:19:04
 *@Description功能: * */
public class Asease extends LinearLayout {

    private TextView aseas_add;
    private TextView aseas_jian;
    private TextView aseas_num;
    public DataCallBack dataCallBack;

    public Asease(Context context) {
        super(context);
        initContext(context);
    }

    public Asease(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initContext(context);
    }

    public Asease(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContext(context);
    }

    private void initContext(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.asease, this, true);
        aseas_add = (TextView) inflate.findViewById(R.id.aseas_add);
        aseas_jian = (TextView) inflate.findViewById(R.id.aseas_jian);
        aseas_num = (TextView) inflate.findViewById(R.id.aseas_num);
        initData();
    }

    private void initData() {
        aseas_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = aseas_num.getText().toString();
                Integer nums = Integer.valueOf(s);
                nums++;
                aseas_num.setText(nums+"");
                dataCallBack.back(nums);
            }
        });
        aseas_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = aseas_num.getText().toString();
                Integer nums = Integer.valueOf(ss);
                nums--;
                if (nums<0){
                    nums=0;
                    Toast.makeText(getContext(), "最小值", Toast.LENGTH_SHORT).show();
                }
                aseas_num.setText(nums+"");
                dataCallBack.back(nums);
            }
        });
    }

    public void setDataCallBack(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    public interface DataCallBack{
        void back(int numa);
    }

    public void setNum(int nums){
        aseas_num.setText(nums+"");
    }
}
