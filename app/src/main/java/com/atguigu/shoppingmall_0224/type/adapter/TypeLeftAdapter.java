package com.atguigu.shoppingmall_0224.type.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.shoppingmall_0224.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：田学伟 on 2017/6/16 16:28
 * QQ：93226539
 * 作用：
 */

public class TypeLeftAdapter extends BaseAdapter {
    private final Context mContext;
    private final String[] datas;
    /**
     * 被点击的位置
     */
    private int selectPositon;

    public TypeLeftAdapter(Context mContext, String[] titles) {
        this.mContext = mContext;
        this.datas = titles;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_type, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //根据位置得到对应的数据
        viewHolder.tvTitle.setText(datas[position]);
        if(selectPositon ==position) {
            //高亮
            convertView.setBackgroundResource(R.drawable.type_item_background_selector);
            viewHolder.tvTitle.setTextColor(Color.parseColor("#fd3f3f"));
        }else {
            //设置默认
            convertView.setBackgroundResource(R.drawable.bg2);  //其他项背景
            viewHolder.tvTitle.setTextColor(Color.parseColor("#323437"));
        }

        return convertView;
    }

    public void changeSelectPosition(int position) {
        this.selectPositon = position;
    }

    static class ViewHolder {
        @InjectView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
