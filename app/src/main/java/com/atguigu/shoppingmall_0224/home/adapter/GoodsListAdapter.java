package com.atguigu.shoppingmall_0224.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.home.bean.TypeListBean;
import com.atguigu.shoppingmall_0224.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：田学伟 on 2017/6/19 10:17
 * QQ：93226539
 * 作用：
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<TypeListBean.ResultEntity.PageDataEntity> datas;


    public GoodsListAdapter(Context mContext, List<TypeListBean.ResultEntity.PageDataEntity> page_data) {
        this.mContext = mContext;
        this.datas = page_data;
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_goods_list, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TypeListBean.ResultEntity.PageDataEntity pageDataEntity = datas.get(position);

        //绑定数据
        holder.tvName.setText(pageDataEntity.getName());
        holder.tvPrice.setText("￥" + pageDataEntity.getCover_price());
        String imageUrl = Constants.BASE_URL_IMAGE + pageDataEntity.getFigure();
        Glide.with(mContext)
                .load(imageUrl)
                .placeholder(R.drawable.new_img_loading_2)
                .error(R.drawable.new_img_loading_2)
                .into(holder.ivHot);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_hot)
        ImageView ivHot;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_price)
        TextView tvPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

            //设置item的点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnItemClick(datas.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {

        void OnItemClick(TypeListBean.ResultEntity.PageDataEntity pageDataEntity);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }
}
