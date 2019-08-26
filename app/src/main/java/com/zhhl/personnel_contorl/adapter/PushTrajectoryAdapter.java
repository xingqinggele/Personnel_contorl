package com.zhhl.personnel_contorl.adapter;

import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.xinjia.Petitiondata;


import butterknife.BindView;

/**
 * Created by miao on 2018/12/28.
 */

/**
 * 新加的注释、
 */
public class PushTrajectoryAdapter extends BaseAdapter<Petitiondata.ZhongdianrenyuanBean, PushTrajectoryAdapter.PushTrajectoryViewHolder> {

    @Override
    protected PushTrajectoryViewHolder create(View view, int itemViewType) {
        return new PushTrajectoryViewHolder(view);
    }


    @Override
    protected void bindView(PushTrajectoryViewHolder vh, int position, Petitiondata.ZhongdianrenyuanBean item) {


        vh.mName.setText(item.getXm());
//        vh.mDate.setText(item.getKckcrq());
//        vh.mContent.setText(item.getTrackdiscription());
        vh.idCard.setText(item.getIdcode());
        vh.mTime.setText(item.getCreatetime());
//        base64转换
//        String aa = base.substring(base.indexOf(",")+1);
//        Bitmap bitmap=null;
//        byte[]bitmapArray;
//        bitmapArray= Base64.decode(aa, Base64.DEFAULT);
//        bitmap= BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
//        vh.ceshi.setImageURI();
//        vh.mTime.setVisibility(View.GONE);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_zaitao_renyuan;
    }

    class PushTrajectoryViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.idCard)
        TextView idCard;
        @BindView(R.id.mContent)
        TextView mContent;
        @BindView(R.id.mTime)
        TextView mTime;

        @BindView(R.id.mName)
        TextView mName;
        @BindView(R.id.mDate)
        TextView mDate;

        @BindView(R.id.ceshi)
        SimpleDraweeView ceshi;

        PushTrajectoryViewHolder(View view) {
            super(view);
        }
    }

}
