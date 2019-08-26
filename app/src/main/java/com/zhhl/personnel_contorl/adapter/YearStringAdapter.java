package com.zhhl.personnel_contorl.adapter;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by miao on 2018/10/26.
 */
public class YearStringAdapter extends BaseAdapter<String, YearStringAdapter.YearViewHolder> {

    public YearStringAdapter(ArrayList<String> data) {
        super(data);
    }

    public YearStringAdapter() {
        super(new ArrayList<>());
    }

    @Override
    protected YearViewHolder create(View view, int itemViewType) {
        return new YearViewHolder(view);
    }

    @Override
    protected void bindView(YearViewHolder yearViewHolder, int position, String item) {
        yearViewHolder.mText.setText(item);
    }

    @Override
    protected int getDefaultLayout() {
        return android.R.layout.simple_list_item_1;
    }

    protected static class YearViewHolder extends BaseAdapter.ViewHolder {
        @BindView(android.R.id.text1)
        TextView mText;

        YearViewHolder(View view) {
            super(view);
        }
    }
}
