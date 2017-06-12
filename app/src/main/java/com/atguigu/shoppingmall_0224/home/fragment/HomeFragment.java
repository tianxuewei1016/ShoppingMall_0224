package com.atguigu.shoppingmall_0224.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.base.BaseFragment;
import com.atguigu.shoppingmall_0224.home.bean.HomeBean;
import com.atguigu.shoppingmall_0224.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * 作者：田学伟 on 2017/6/11 15:14
 * QQ：93226539
 * 作用：主页
 */

public class HomeFragment extends BaseFragment {


    @InjectView(R.id.ll_main_scan)
    LinearLayout llMainScan;
    @InjectView(R.id.tv_search_home)
    TextView tvSearchHome;
    @InjectView(R.id.tv_message_home)
    TextView tvMessageHome;
    @InjectView(R.id.rv_home)
    RecyclerView rvHome;
    @InjectView(R.id.ib_top)
    ImageButton ibTop;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
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
        getDataFromNet();
    }

    /**
     * 联网请求数据
     */
    private void getDataFromNet() {
        OkHttpUtils.get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        Log.e("TAG", "联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e("TAG", "联网成功==");
                        processData(response);
                    }
                });
    }

    /**
     * 解析数据
     *
     * @param json
     */
    private void processData(String json) {
        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);
//        Log.e("TAG", "解析数据成功==" + homeBean.getResult().getHot_info().get(0).getName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}