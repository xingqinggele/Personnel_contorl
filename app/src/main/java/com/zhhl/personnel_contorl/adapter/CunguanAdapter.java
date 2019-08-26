package com.zhhl.personnel_contorl.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.data.Cunguanrenyuan;


import butterknife.BindView;

/**
 * Created by miao on 2018/11/25.
 */
public class CunguanAdapter extends BaseAdapter<Cunguanrenyuan.CunguanrenyuanBean, CunguanAdapter.CunguanViewHolder> {


    @Override
    protected CunguanViewHolder create(View view, int itemViewType) {
        return new CunguanViewHolder(view);
    }

    @Override
    protected void bindView(CunguanViewHolder vh, int position, Cunguanrenyuan.CunguanrenyuanBean item) {
        vh.mContent.setText(item.getGzdwGajgjgdm() + (TextUtils.isEmpty(item.getZw()) ? "" : (":" + item.getZw())));
        vh.idCard.setText(item.getGmsfhm());
        vh.name.setText(item.getXm());
        vh.mTime.setText(item.getRgxksj());
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_cunguan_renyuan;
    }


    class CunguanViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.idCard)
        TextView idCard;
        @BindView(R.id.mContent)
        TextView mContent;
        @BindView(R.id.mTime)
        TextView mTime;
        @BindView(R.id.name)
        TextView name;

        CunguanViewHolder(View view) {
            super(view);
        }
    }
}
