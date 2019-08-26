package com.zhhl.personnel_contorl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.RecyclerOnItemClick;
import com.zhhl.personnel_contorl.data.StringFlag;

import java.util.ArrayList;

/**
 * Created by miao on 2018/11/25.
 */
public class HorName extends RecyclerView.Adapter<HorName.VH> implements View.OnClickListener {

    private final Context context;
    private int checkId = 0;
    private RecyclerOnItemClick click;

    public HorName(Context context) {

        this.context = context;
    }

    public void setClick(RecyclerOnItemClick click) {
        this.click = click;
    }

    public ArrayList<StringFlag> getNames() {
        return names;
    }

    public void setNames(ArrayList<StringFlag> names) {
        this.names = names;
        notifyDataSetChanged();
    }

    public void addNames(ArrayList<StringFlag> names) {
        this.names.addAll(names);
        notifyDataSetChanged();
    }

    private ArrayList<StringFlag> names = new ArrayList<>();


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rec_text, viewGroup, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.mText.setText(names.get(i).name);
        vh.mTextWrapper.setTag(i);
        vh.mTextWrapper.setOnClickListener(this);
        vh.mText.setTextColor(i == checkId ? context.getResources().getColor(R.color.colorAccent) : context.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        names.get(checkId).flag = false;
        notifyItemChanged(checkId);
        checkId = tag;
        names.get(checkId).flag = true;
        notifyItemChanged(checkId);
        if (click != null)
            click.onItemClick(v, tag);
    }

    public class VH extends RecyclerView.ViewHolder {

        private final TextView mText;
        private final FrameLayout mTextWrapper;


        VH(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.mText);
            mTextWrapper = itemView.findViewById(R.id.mTextWrapper);
        }
    }
}
