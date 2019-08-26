package com.zhhl.personnel_contorl.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.data.GuijiCQDWrapper;
import com.zhhl.personnel_contorl.data.GxrData2;
import com.zhhl.personnel_contorl.data.PersonTrajectory;
import com.zhhl.personnel_contorl.data.SimpleCarInfo;
import com.zhhl.personnel_contorl.data.Trajectory;
import com.zhhl.personnel_contorl.utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by miao on 2018/9/5.
 */
public class PersonAnalysisAdapter extends BaseAdapter<PersonTrajectory, BaseAdapter.ViewHolder> {

    public PersonAnalysisAdapter(ArrayList<PersonTrajectory> data) {
        super(data);
    }

    @Override
    public ViewHolder create(View view, int idx) {
        switch (idx) {
            case 0:
                return new TrajectoryViewHolder(view);
            case 1:
                return new TrajectoryViewHolder2(view);
            case 2:
                return new TrajectoryViewHolder3(view);
            case 3:
                return new TrajectoryViewHolder4(view);
        }
        return null;
    }

    @Override
    protected void bindView(ViewHolder _vh, int position, PersonTrajectory item) {

        if (item.getType() < 20) {
            TrajectoryViewHolder vh = (TrajectoryViewHolder) _vh;
            switch (item.getType()) {

                case 6:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
                    vh.mTrajectoryType.setText("常去地:");
                    vh.mTrajectoryTypeName.setText(/*item.getNoId().getResult()*/"五洲花园大酒店");
                    vh.mTrajectoryLocation.setText(/*item.getNoId().getAddress()*/"吉林省长春市南湖街道");
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
                    vh.mTrajectoryIcon.setImageResource(R.drawable.ic_gj);
                    break;

            }

            vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
            switch (item.getType()) {
                case 12:
                    Trajectory.KecheBean kc = item.getKecheBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("客车购票:");
                    vh.mTrajectoryTypeName.setText("");
                    vh.mTrajectoryLocation.setText(kc.getFcjgmc() + "-" + kc.getDdzmc());
                    break;
                case 13:
                    Trajectory.MinhangBean mh = item.getMinhangBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("民航购票:");
                    vh.mTrajectoryTypeName.setText(mh.getCyhkgsdm() + mh.getHbh());
                    vh.mTrajectoryLocation.setText(mh.getQfjcdm() + "-" + mh.getDdjcdm());
                    break;
                case 14:
                    vh.mTrajectoryType.setText("网吧:");
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    Trajectory.ShangwangBean sw = item.getShangwangBean();
                    vh.mTrajectoryTypeName.setText("");
                    vh.mTrajectoryLocation.setText(sw.getYycsDwmc());
                    break;
                case 15:
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    Trajectory.TielugoupiaoBean tl = item.getTielugoupiaoBean();
                    vh.mTrajectoryType.setText("铁路购票:");
                    vh.mTrajectoryTypeName.setText(tl.getCc());
                    vh.mTrajectoryLocation.setText(tl.getSfd() + "-" + tl.getMdd());
                    break;
                case 16:
                    Trajectory.ZhudianBean zd = item.getZhudianBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("酒店:");
                    vh.mTrajectoryTypeName.setText("");
                    vh.mTrajectoryLocation.setText(zd.getLdMc());
                    break;
                case 17:
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    Trajectory.KakouBean kk = item.getKakouBean();
                    vh.mTrajectoryType.setText("卡口过车:");
                    vh.mTrajectoryTypeName.setText(kk.getTgfx());
                    vh.mTrajectoryLocation.setText(kk.getKkmc());
                    break;
            }


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
        } else if (item.getType() > 20 && item.getType() < 30) {
            TrajectoryViewHolder2 vh2 = (TrajectoryViewHolder2) _vh;
            GuijiCQDWrapper wrapper = item.getWrapper();
            if (position == 0) {
                vh2.toptip.setVisibility(View.VISIBLE);
            } else {
                vh2.toptip.setVisibility(View.GONE);
            }
            vh2.counter.setText(wrapper.tj + "次");
            vh2.name.setText(wrapper.ldmc);
        } else if (item.getType() > 30 && item.getType() < 40) {

            TrajectoryViewHolder3 vh3 = (TrajectoryViewHolder3) _vh;
            vh3.yuanyin.setVisibility(View.GONE);
            switch (item.getType()) {
                case 33:
                    GxrData2.HunyinBean hunyin = item.getHunyin2();
                    vh3.name.setText(hunyin.getPeiou());
                    vh3.sfzh.setText(hunyin.getPeioucode());
                    int sexId = Integer.parseInt(hunyin.getPeioucode().substring(16, 17));
                    vh3.gxId.setText("与本人关系(" + (sexId % 2 == 0 ? "妻子" : "丈夫") + ")");
                    break;
                case 34:
                    GxrData2.QinshuBean qinshu = item.getQinshu2();
                    vh3.name.setText(qinshu.getXm());
                    vh3.sfzh.setText(qinshu.getGmsfhm());
                    vh3.gxId.setText("与户主关系:" + qinshu.getYhzgxdm());
                    break;
            }
        } else if (item.getType() > 50 && item.getType() < 60) {
            TrajectoryViewHolder4 vh4 = (TrajectoryViewHolder4) _vh;
            SimpleCarInfo carInfo = item.getCarInfo();
            vh4.carCode.setText(carInfo.getCarCode());
            vh4.carName.setText(carInfo.getCarName());
            vh4.company.setText(carInfo.getCompany());
            if (!TextUtils.isEmpty(carInfo.getBelongTo()))
                vh4.belongTo.setText(carInfo.getBelongTo());
        }
    }

    @Override
    protected int getAdapterItemViewType(int position) {
        int type = getItem(position).getType();
        if (type < 20)
            return 0;
        else if (type > 20 && type < 30) return 1;
        else if (type > 30 && type < 50) {
            return 2;
        } else return 3;
    }

    public void addData(ArrayList<PersonTrajectory> list) {
        if (list != null && list.size() > 0) {
            data.addAll(list);
            Collections.sort(data);
            notifyDataSetChanged();
        }
    }

    @Override
    protected boolean multiItemEnable() {
        return true;
    }

    @Override
    protected int[] getMultiLayout() {
        return new int[]{getDefaultLayout(), R.layout.item_cqd, R.layout.item_gxr, R.layout.item_car_info};
    }

    protected int getAdapterViewTypeCount() {
        return 2;
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.ss_item_trajectory_2;
    }

    public void add(List<PersonTrajectory> obj) {
        data.addAll(obj);
        Collections.sort(data);
        notifyDataSetChanged();
    }

    static class TrajectoryViewHolder extends ViewHolder {
        @BindView(R.id.mTrajectoryDate)
        TextView mTrajectoryDate;
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
        @BindView(R.id.mTrahectoryIsNew)
        TextView mTrajectoryIsNew;
        @BindView(R.id.mTrajectoryLocation)
        TextView mTrajectoryLocation;
        @BindView(R.id.mTrajectoryTime)
        TextView mTrajectoryTime;

        TrajectoryViewHolder(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder2 extends ViewHolder {
        @BindView(R.id.toptips)
        TextView toptip;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.counter)
        TextView counter;

        TrajectoryViewHolder2(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder3 extends ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.gxId)
        TextView gxId;
        @BindView(R.id.sfzh)
        TextView sfzh;
        @BindView(R.id.yuanyin)
        TextView yuanyin;

        TrajectoryViewHolder3(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder4 extends ViewHolder {
        @BindView(R.id.carCode)
        TextView carCode;
        @BindView(R.id.carName)
        TextView carName;
        @BindView(R.id.company)
        TextView company;
        @BindView(R.id.belongTo)
        TextView belongTo;

        TrajectoryViewHolder4(View view) {
            super(view);
        }
    }


}

