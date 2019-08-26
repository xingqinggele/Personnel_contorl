package com.zhhl.personnel_contorl.xinjia;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.zhhl.personnel_contorl.R;

import java.util.List;

public class Home_gen_opera_details_guige_Adapter extends BaseAdapter
{
	List<Peti_datalis_data.GuijiBean> apk_list;
	LayoutInflater inflater;
	private Context context;
	private int selectorPosition;
	public Home_gen_opera_details_guige_Adapter(Context context, List<Peti_datalis_data.GuijiBean> apk_list)
	{
		this.apk_list = apk_list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	public void onDateChange(List<Peti_datalis_data.GuijiBean> apk_list)
	{
		this.apk_list = apk_list;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return apk_list.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return apk_list.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		final Peti_datalis_data.GuijiBean entity = apk_list.get(position);
		ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.ss_item_trajectory_2, null);
			holder.m_dianpu_name_tv = convertView.findViewById(R.id.mTrajectoryDate);
			holder.mTrajectoryType = convertView.findViewById(R.id.mTrajectoryType);
			holder.mTrahectoryIsNew = convertView.findViewById(R.id.mTrahectoryIsNew);
			holder.mTrajectoryLocation = convertView.findViewById(R.id.mTrajectoryLocation);
			holder.mTrajectoryTime = convertView.findViewById(R.id.mTrajectoryTime);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		if (!TextUtils.isEmpty(entity.getHccc()))
			{
				holder.mTrajectoryType.setText("铁路购票："+entity.getHccc());
				holder.m_dianpu_name_tv.setText(entity.getHckcsj());
				holder.mTrajectoryLocation.setText(entity.getHcsfdd()+"-"+entity.getHcdddd());
				holder.mTrajectoryTime.setText(entity.getCreatetime());


			}
			else if (!TextUtils.isEmpty(entity.getKccc()))
			{
				holder.mTrajectoryType.setText("客车购票："+entity.getHccc());
				holder.m_dianpu_name_tv.setText(entity.getKckcrq());
				holder.m_dianpu_name_tv.setText(entity.getHckcsj());
				holder.mTrajectoryLocation.setText(entity.getKcsfdd()+"-"+entity.getKcdddd());
				holder.mTrajectoryTime.setText(entity.getCreatetime());

			}
			else if (!TextUtils.isEmpty(entity.getFjhb()))
			{
				holder.mTrajectoryType.setText("民航购票："+entity.getFjhb());
				holder.m_dianpu_name_tv.setText(entity.getFjqfsj());
				holder.mTrajectoryLocation.setText(entity.getFjsfdd()+"-"+entity.getFjdddd());
				holder.mTrajectoryTime.setText(entity.getCreatetime());


			}
			else if (!TextUtils.isEmpty(entity.getZdmc()))
			{
				holder.mTrajectoryType.setText("酒店："+entity.getZdmc());
				holder.m_dianpu_name_tv.setText(entity.getZdsj());
				holder.mTrajectoryLocation.setText(entity.getZdwz());
				holder.mTrajectoryTime.setText(entity.getCreatetime());

			}
			else if (!TextUtils.isEmpty(entity.getWbmc()))
			{
				holder.mTrajectoryType.setText("网吧："+entity.getWbmc());
				holder.m_dianpu_name_tv.setText(entity.getSwsj());
				holder.mTrajectoryLocation.setText(entity.getWbmc());
				holder.mTrajectoryTime.setText(entity.getCreatetime());

			}
			else if (!TextUtils.isEmpty(entity.getCgkksj()))
			{
				holder.mTrajectoryType.setText("卡口过车："+entity.getCph());
				holder.m_dianpu_name_tv.setText(entity.getCgkkwz());
				holder.mTrajectoryLocation.setText(entity.getCgkkwz());
				holder.mTrajectoryTime.setText(entity.getCreatetime());

			}

		if (position == 0) {
			holder.mTrahectoryIsNew.setVisibility(View.VISIBLE);
//			holder.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
//			holder.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
		} else if (position + 1 == getCount()) {
			holder.mTrahectoryIsNew.setVisibility(View.INVISIBLE);
//			holder.mTrajectoryLineTop.setVisibility(View.VISIBLE);
//			holder.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);

		} else {
			holder.mTrahectoryIsNew.setVisibility(View.INVISIBLE);
//			holder.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
//			holder.mTrajectoryLineTop.setVisibility(View.VISIBLE);
		}

		if (getCount() == 1) {
			holder.mTrahectoryIsNew.setVisibility(View.VISIBLE);
//			holder.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
//			holder.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);
		}


		return convertView;
	}

	class ViewHolder
	{
		TextView m_dianpu_name_tv;
		TextView mTrajectoryType;
		TextView mTrahectoryIsNew;
		TextView mTrajectoryLocation;
		TextView mTrajectoryTime;


	}

	public void addListView(Peti_datalis_data.GuijiBean pBean)
	{
		apk_list.add(pBean);

	}

	public void changeState(int pos)
	{
		selectorPosition = pos;
		notifyDataSetChanged();

	}



}
