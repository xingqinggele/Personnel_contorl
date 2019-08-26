//package com.zhhl.smartpush.adapter;
//
//import android.app.PendingIntent;
//import android.app.TaskStackBuilder;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.zhhl.smartpush.MainActivity;
//import com.zhhl.smartpush.R;
//import com.zhhl.smartpush.activity.ShangfangActivity;
//import com.zhhl.smartpush.activity.UnlockActivity;
//import com.zhhl.smartpush.activity.ZaitaoActivity;
//import com.zhhl.smartpush.data.PushInfo;
//import com.zhhl.smartpush.mvp.view.activities.PersonTrajectoryAnalysisActivity;
//import com.zhhl.smartpush.support.DisableItem;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> implements View.OnLongClickListener, View.OnClickListener, DisableItem.OnDismissListener {
//
//
//    private int _openId = -1;
//    private ArrayList<PushInfo.DataBean> dataBeans = new ArrayList<>();
//
//    private Context context;
//
//    private ArrayList<View.OnClickListener> onItemClickListener = new ArrayList<>();
//
//    @NonNull
//    @Override
//    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        context = viewGroup.getContext();
//        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_unlock_wrap, viewGroup, false);
//        return new NotificationViewHolder(inflate);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NotificationViewHolder vh, int i) {
//        vh.currentTime.setText(dataBeans.get(i).getCreatetime());
//        vh.message.setText(dataBeans.get(i).getTrackdiscription());
//        vh.itemView.setOnLongClickListener(this);
//        vh.itemView.setOnClickListener(this);
//        vh.itemView.setTag(i);
//        vh.message.setVisibility(dataBeans.get(i).isOpen() ? View.VISIBLE : View.GONE);
//        vh.item.setPosition(i);
//        vh.item.setOnDismissListener(this);
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataBeans.size();
//    }
//
//    public void addOnItemClickListener(View.OnClickListener onItemClickListener) {
//        this.onItemClickListener.add(onItemClickListener);
//    }
//
//    @Override
//    public boolean onLongClick(View v) {
//        int id = (int) v.getTag();
//        if (_openId != -1) {
//            int last = _openId;
//            _openId = id;
//
//            if (last == _openId) {
//                dataBeans.get(_openId).setOpen(false);
//                notifyItemChanged(_openId);
//                _openId = -1;
//
//            } else {
//                dataBeans.get(last).setOpen(false);
//                dataBeans.get(_openId).setOpen(true);
//                notifyItemChanged(last);
//                notifyItemChanged(_openId);
//            }
//
//        } else {
//            _openId = id;
//            dataBeans.get(_openId).setOpen(true);
//            notifyItemChanged(_openId);
//        }
//        return true;
//    }
//
//    @Override
//    public void onClick(View v) {
//        int pos = (int) v.getTag();
//        Log.e(TAG, "onClick: " + pos);
//        PushInfo.DataBean dataBean = dataBeans.get(pos);
//        context.startActivities(makeActivityReStart(/*dataBean.getZtidcard()*/"429006199301054295", /*dataBean.getTracktype()*/"0"));
//        if (onItemClickListener.size() > 0) {
//            for (View.OnClickListener o : onItemClickListener) {
//                o.onClick(v);
//            }
//        }
//
//    }
//
//    private Intent[] makeActivityReStart(String idNumber, String flag) {
//        Intent[] intents = new Intent[3];
//        intents[2] = new Intent(context, PersonTrajectoryAnalysisActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("idNumber", idNumber).putExtra("push", true);
////        intents[2] = new Intent(context, PersonTrajectoryAnalysisActivity.class)
//        switch (flag) {
//            case "0":
//                intents[1] = new Intent(context, ZaitaoActivity.class);
//                break;
//            case "1":
//                intents[1] = new Intent(context, ShangfangActivity.class);
//                break;
//            default:
//        }
//        intents[0] = Intent.makeRestartActivityTask(new ComponentName(context, MainActivity.class));
//        return intents;
//    }
//
//    public void setData(ArrayList<PushInfo.DataBean> data) {
//        int size = this.dataBeans.size();
//        this.dataBeans = data;
////        notifyItemRangeInserted(size,data.size());
//        notifyDataSetChanged();
////        Log.e(TAG, "setData: " + data.size());
//    }
//
//    private String TAG = getClass().getSimpleName();
//
//    @Override
//    public void dismissed(DisableItem disableItem) {
//        notifyItemRemoved(disableItem.getPosition());
//    }
//
//    class NotificationViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.currentTime)
//        TextView currentTime;
//        @BindView(R.id.message)
//        TextView message;
//        @BindView(R.id.mDismiss)
//        DisableItem item;
//
//        public NotificationViewHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }
//
//}


package com.zhhl.personnel_contorl.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zhhl.personnel_contorl.MainActivity;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.mvp.view.activities.AtLargeActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.PersonTrajectoryAnalysisActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.PetitionActivity;
import com.zhhl.personnel_contorl.support.DisableItem;


import java.util.ArrayList;

import butterknife.BindView;

public class NotificationAdapter extends BaseAdapter<PushInfo.DataBean, NotificationAdapter.NotificationViewHolder> implements View.OnLongClickListener, View.OnClickListener, DisableItem.OnDismissListener {

    public interface CallFinish {
        void finish();
    }

    private CallFinish finish;


    public void setCallFinish(CallFinish finish) {
        this.finish = finish;
    }

    private int _openId = -1;

    private Context context;

    private ArrayList<View.OnClickListener> onItemClickListener = new ArrayList<>();


    public void addOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener.add(onItemClickListener);
    }

    @Override
    public boolean onLongClick(View v) {
        int id = (int) v.getTag();
        if (_openId != -1) {
            int last = _openId;
            _openId = id;

            if (last == _openId) {
                getData().get(_openId).setOpen(false);
//                notifyItemChanged(_openId);
                _openId = -1;

            } else {
                getData().get(last).setOpen(false);
                getData().get(_openId).setOpen(true);
//                notifyItemChanged(last);
//                notifyItemChanged(_openId);
            }

        } else {
            _openId = id;
            getData().get(_openId).setOpen(true);
//            notifyItemChanged(_openId);
        }
        notifyDataSetInvalidated();
        return true;
    }

    @Override
    public void onClick(View v) {
        int pos = (int) v.getTag();
        Log.e(TAG, "onClick: " + pos);
        PushInfo.DataBean dataBean = getData().get(pos);
        context.startActivities(makeActivityReStart(/*dataBean.getZtidcard()*/"429006199301054295", /*dataBean.getTracktype()*/"0"));
        if (onItemClickListener.size() > 0) {
            for (View.OnClickListener o : onItemClickListener) {
                o.onClick(v);
            }
        }
    }

    private Intent[] makeActivityReStart(String idNumber, String flag) {
        Intent[] intents = new Intent[3];
        intents[2] = new Intent(context, PersonTrajectoryAnalysisActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("idNumber", idNumber).putExtra("push", true);
        switch (flag) {
            case "0":
                intents[1] = new Intent(context, AtLargeActivity.class);
                break;
            case "1":
                intents[1] = new Intent(context, PetitionActivity.class);
                break;
            default:
        }
        intents[0] = Intent.makeRestartActivityTask(new ComponentName(context, MainActivity.class));
        return intents;
    }

    @Override
    protected NotificationViewHolder create(View view, int itemViewType) {
        if (context == null) {
            context = view.getContext();
        }
        return new NotificationViewHolder(view);
    }

    @Override
    protected void bindView(NotificationViewHolder vh, int i, PushInfo.DataBean item) {
        vh.currentTime.setText(getData().get(i).getCreatetime());
        vh.message.setText(getData().get(i).getTrackdiscription());
        vh.itemView.setOnLongClickListener(this);
        vh.itemView.setOnClickListener(this);
        vh.itemView.setTag(i);
        vh.message.setVisibility(getData().get(i).isOpen() ? View.VISIBLE : View.GONE);
        vh.item.setPosition(i);
        vh.item.setOnDismissListener(this);
    }

    public void setData(ArrayList<PushInfo.DataBean> data) {
        this.data.addAll(data);
        Log.e(TAG, "setData: " + data.size());
        notifyDataSetChanged();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_unlock_wrap;
    }

    private String TAG = getClass().getSimpleName();

    @Override
    public void dismissed(DisableItem disableItem) {
        data.remove(disableItem.getPosition());
        if (data.size() == 0) {
            finish.finish();
        }
        notifyDataSetInvalidated();
    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    class NotificationViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.currentTime)
        TextView currentTime;
        @BindView(R.id.message)
        TextView message;
        @BindView(R.id.mDismiss)
        DisableItem item;

        View itemView;

        public NotificationViewHolder(View view) {
            super(view);
            itemView = view;
        }
    }

}
