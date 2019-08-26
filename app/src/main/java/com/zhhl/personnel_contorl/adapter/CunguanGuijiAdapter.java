package com.zhhl.personnel_contorl.adapter;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.data.CunguanGuijiWrapper;
import com.zhhl.personnel_contorl.data.Cunguanguiji;
import com.zhhl.personnel_contorl.utils.DateUtil;


import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;

/**
 * Created by miao on 2018/11/25.
 */
public class CunguanGuijiAdapter extends BaseAdapter<CunguanGuijiWrapper, CunguanGuijiAdapter.TrajectoryViewHolder> {


    @Override
    protected TrajectoryViewHolder create(View view, int itemViewType) {
        return new TrajectoryViewHolder(view);
    }

    @Override
    protected void bindView(TrajectoryViewHolder vh, int position, CunguanGuijiWrapper item) {

        vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
        switch (item.getType()) {
            case 1:
                Cunguanguiji.CheliangBean cl = item.getCheliangBean();
                vh.mTrajectoryType.setText("车辆信息");
                vh.mTrajectoryTypeName.setText(cl.getGajtglfzjgslmc() + cl.getJdchphm().substring(1));
                vh.mTrajectoryLocation.setText(cl.getJdcsyrXzzDzmc());
                vh.mTrajectoryMsg.setText(cl.getZzcDwmc() + cl.getZwppmc());
                vh.mTrajectoryWho.setText(cl.getJdcsyrJdcsyrmc());
                break;
            case 2:
                Cunguanguiji.BudongchanBean kc = item.getBudongchanBean();
                vh.mTrajectoryType.setText("不动产信息");
                vh.mTrajectoryTypeName.setText(kc.getGyqk());
                vh.mTrajectoryLocation.setText(kc.getDz());
                vh.mTrajectoryMsg.setText(kc.getBdcqzh());
                vh.mTrajectoryWho.setText(kc.getQlrmc());
                break;
            case 3:

                Cunguanguiji.GetixinxiBean mh = item.getGetixinxiBean();
                vh.mTrajectoryType.setText("个体信息");
                vh.mTrajectoryTypeName.setText(mh.getJyhySm());
                vh.mTrajectoryLocation.setText(mh.getQyDwmc());
                vh.mTrajectoryMsg.setText(mh.getJyfwzy());
                vh.mTrajectoryWho.setText(mh.getFddbrxm());
                break;
            case 4:
                vh.mTrajectoryType.setText("企业信息");
                Cunguanguiji.QiyexinxiBean sw = item.getQiyexinxiBean();
                vh.mTrajectoryTypeName.setText(sw.getDwmc());
                vh.mTrajectoryLocation.setText(sw.getZsDzmc());
                vh.mTrajectoryMsg.setText("");
                vh.mTrajectoryWho.setText(sw.getFddbrXm());
                break;
            case 5:
                Cunguanguiji.ShengneifangchanBean tl = item.getShengneifangchanBean();
                vh.mTrajectoryType.setText("省内房产信息");
                vh.mTrajectoryTypeName.setText(Html.fromHtml(tl.getJzmjMjpfm() + "m<sup>2</sup>"));
                vh.mTrajectoryLocation.setText(tl.getQyMs());
                vh.mTrajectoryMsg.setText(tl.getSjXxlyms());
                vh.mTrajectoryWho.setText(tl.getXm());
                break;
            case 6:
                Cunguanguiji.WeifafanzuiBean zd = item.getWeifafanzuiBean();
                vh.mTrajectoryType.setText("违法犯罪行为");
                vh.mTrajectoryTypeName.setText(zd.getAjmc());
                vh.mTrajectoryLocation.setText(zd.getWffzddDzmc());
                vh.mTrajectoryMsg.setText("");
                vh.mTrajectoryWho.setText(zd.getXm());
                break;
        }
        vh.msg.setVisibility(TextUtils.isEmpty(vh.mTrajectoryMsg.getText()) ? View.GONE : View.VISIBLE);
//        vh.mTrajectoryLocation.setText(item.getLocation());
        vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));


        if (position == 0) {
            vh.mTrajectoryIsNew.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
        } else if (position + 1 == getCount()) {
            vh.mTrajectoryIsNew.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);

        } else {
            vh.mTrajectoryIsNew.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.VISIBLE);
        }

        if (getCount() == 1) {
            vh.mTrajectoryIsNew.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_trajectory;
    }

    //}
    @Override
    public void addData(ArrayList<CunguanGuijiWrapper> obj) {
        data.addAll(obj);
        Collections.sort(data);
        notifyDataSetChanged();

    }

    static class TrajectoryViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.mTrajectoryWho)
        TextView mTrajectoryWho;
        @BindView(R.id.mTrajectoryDate)
        TextView mTrajectoryDate;
        @BindView(R.id.mTrahectoryIsNew)
        TextView mTrajectoryIsNew;
        @BindView(R.id.mTrajectoryLineTop)
        View mTrajectoryLineTop;
        @BindView(R.id.mTrajectoryIcon)
        ImageView mTrajectoryIcon;
        @BindView(R.id.mTrajectoryLineBottom)
        View mTrajectoryLineBottom;
        @BindView(R.id.mTrajectoryType)
        TextView mTrajectoryType;
        @BindView(R.id.mTrajectoryTypeName)
        TextView mTrajectoryTypeName;
        @BindView(R.id.mTrajectoryLocation)
        TextView mTrajectoryLocation;
        @BindView(R.id.mTrajectoryTime)
        TextView mTrajectoryTime;
        @BindView(R.id.mTrajectoryMsg)
        TextView mTrajectoryMsg;
        @BindView(R.id.msg)
        LinearLayout msg;

        TrajectoryViewHolder(View view) {
            super(view);
        }
    }
}
