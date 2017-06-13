package com.atguigu.shoppingmall_0224.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.home.bean.HomeBean;
import com.atguigu.shoppingmall_0224.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：田学伟 on 2017/6/13 08:41
 * QQ：93226539
 * 作用：
 */

public class SeckillRecyclerViewAdapter extends RecyclerView.Adapter<SeckillRecyclerViewAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<HomeBean.ResultEntity.SeckillInfoEntity.ListEntity> datas;

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public SeckillRecyclerViewAdapter(Context mContext, HomeBean.ResultEntity.SeckillInfoEntity seckill_info) {
        this.mContext = mContext;
        this.datas = seckill_info.getList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_seckill, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //1.根据位置得到对应的数据
        HomeBean.ResultEntity.SeckillInfoEntity.ListEntity listEntity = datas.get(position);
        //2.绑定数据
        holder.tvCoverPrice.setText("￥" + listEntity.getCover_price());
        holder.tvOriginPrice.setText("￥" + listEntity.getOrigin_price());
        Glide.with(mContext)
                .load(Constants.BASE_URL_IMAGE + listEntity.getFigure())
                .into(holder.ivFigure);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_figure)
        ImageView ivFigure;
        @InjectView(R.id.tv_cover_price)
        TextView tvCoverPrice;
        @InjectView(R.id.tv_origin_price)
        TextView tvOriginPrice;
        @InjectView(R.id.ll_root)
        LinearLayout llRoot;

        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        public void OnItemClick(View v, int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }
}
