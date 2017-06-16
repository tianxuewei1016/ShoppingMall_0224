package com.atguigu.shoppingmall_0224.type.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.base.BaseFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：田学伟 on 2017/6/11 15:16
 * QQ：93226539
 * 作用：分类
 */

public class TypeFragment extends BaseFragment {

    @InjectView(R.id.tl_1)
    SegmentTabLayout tl1;
    @InjectView(R.id.iv_type_search)
    ImageView ivTypeSearch;
    @InjectView(R.id.fl_type)
    FrameLayout flType;

    private String[] titles = {"分类", "标签"};
    private ArrayList<BaseFragment> fragments;
    /**
     * 刚才被显示的fragment
     */
    private Fragment tempFragment;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_type, null);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * 1.把数据绑定到控件上的时候，重新该方法
     * 2.联网请求，把得到的数据绑定到视图上
     */
    @Override
    public void initData() {
        super.initData();
        //设置内容
        tl1.setTabData(titles);
        //监听Tab的状态
        tl1.setOnTabSelectListener(new MyOnTabSelectListener());
    }

    class MyOnTabSelectListener implements OnTabSelectListener {

        @Override
        public void onTabSelect(int position) {
            Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTabReselect(int position) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick(R.id.iv_type_search)
    public void onViewClicked() {
    }
}
