package com.atguigu.shoppingmall_0224.home.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.shoppingmall_0224.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GoodsListActivity extends AppCompatActivity {

    @InjectView(R.id.ib_goods_list_back)
    ImageButton ibGoodsListBack;
    @InjectView(R.id.tv_goods_list_search)
    TextView tvGoodsListSearch;
    @InjectView(R.id.ib_goods_list_home)
    ImageButton ibGoodsListHome;
    @InjectView(R.id.tv_goods_list_sort)
    TextView tvGoodsListSort;
    @InjectView(R.id.tv_goods_list_price)
    TextView tvGoodsListPrice;
    @InjectView(R.id.iv_goods_list_arrow)
    ImageView ivGoodsListArrow;
    @InjectView(R.id.ll_goods_list_price)
    LinearLayout llGoodsListPrice;
    @InjectView(R.id.tv_goods_list_select)
    TextView tvGoodsListSelect;
    @InjectView(R.id.ll_goods_list_head)
    LinearLayout llGoodsListHead;
    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    @InjectView(R.id.dl_left)
    DrawerLayout dlLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.ib_goods_list_back, R.id.tv_goods_list_search, R.id.ib_goods_list_home, R.id.tv_goods_list_sort, R.id.tv_goods_list_price, R.id.tv_goods_list_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_goods_list_back:
                finish();
                break;
            case R.id.tv_goods_list_search:
                Toast.makeText(GoodsListActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_goods_list_home:
                Toast.makeText(GoodsListActivity.this, "主页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_goods_list_sort:
                Toast.makeText(GoodsListActivity.this, "综合排序", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_goods_list_price:
                Toast.makeText(GoodsListActivity.this, "价格排序", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_goods_list_select:
                Toast.makeText(GoodsListActivity.this, "筛选排序", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
