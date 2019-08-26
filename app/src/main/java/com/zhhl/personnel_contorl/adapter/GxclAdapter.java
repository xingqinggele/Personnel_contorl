package com.zhhl.personnel_contorl.adapter;

import android.view.View;
import android.widget.TextView;


import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.data.GxclData;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by miao on 2019/1/24.
 */
public class GxclAdapter extends BaseAdapter<GxclData.QsclBean, GxclAdapter.GxclViewHolder> {
    public GxclAdapter(ArrayList<GxclData.QsclBean> data) {
        super(data);
    }

    @Override
    protected GxclViewHolder create(View view, int itemViewType) {
        return new GxclViewHolder(view);
    }

    @Override
    protected void bindView(GxclViewHolder vh, int position, GxclData.QsclBean item) {
        vh.carCode.setText(item.getJdchphm());
        vh.name.setText(item.getJdcsyrJdcsyrmc());
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.gxcl_trajectory;
    }

    static class GxclViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.carCode)
        TextView carCode;
        @BindView(R.id.name)
        TextView name;
        GxclViewHolder(View view) {
            super(view);
        }
    }

}
