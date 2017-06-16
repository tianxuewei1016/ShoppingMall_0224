package com.atguigu.shoppingmall_0224.type.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.base.BaseFragment;
import com.atguigu.shoppingmall_0224.type.adapter.TypeLeftAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：田学伟 on 2017/6/16 15:40
 * QQ：93226539
 * 作用：分类
 */

public class ListFragment extends BaseFragment {


    @InjectView(R.id.lv_left)
    ListView lvLeft;
    @InjectView(R.id.rv_right)
    RecyclerView rvRight;
    //网络请求得到数据
    private String[] titles = new String[]{"小裙子", "上衣", "下装", "外套", "配件", "包包", "装扮", "居家宅品",
            "办公文具", "数码周边", "游戏专区"};

    private TypeLeftAdapter adapter;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_list, null);
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
        //设置左边的适配器
        adapter = new TypeLeftAdapter(mContext,titles);
        lvLeft.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
