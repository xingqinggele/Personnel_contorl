package com.zhhl.personnel_contorl.mvp.view.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.adapter.PushTrajectoryAdapter;
import com.zhhl.personnel_contorl.common.BaseMvpActivity;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.di.component.AppComponent;
import com.zhhl.personnel_contorl.di.component.DaggerConcernedWithDrugsComponent;
import com.zhhl.personnel_contorl.di.module.ConcernedWithDrugsModule;
import com.zhhl.personnel_contorl.mvp.contacts.ConcernedWithDrugsContact;
import com.zhhl.personnel_contorl.mvp.presenter.ConcernedWithDrugsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

/**
 * Created by miao on 2019/4/1.
 */

/**
 * 新加的注释、涉毒人员界面
 */
public class ConcernedWithDrugsActivity extends BaseMvpActivity<ConcernedWithDrugsPresenter> implements ConcernedWithDrugsContact.View {



    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        DaggerConcernedWithDrugsComponent
                .builder()
                .appComponent(appComponent)
                .concernedWithDrugsModule(new ConcernedWithDrugsModule(this)) //请将ConcernedWithDrugsModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @BindView(R.id.refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.mZaitaoRenyuan)
    ListView mZaitaoRenyuan;

    private ProgressDialog dialog;

    private final PushTrajectoryAdapter adapter = new PushTrajectoryAdapter();

    @Override
    protected void initData() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        refreshLayout.setRefreshing(true);
        mZaitaoRenyuan.setAdapter(adapter);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        refreshLayout.setOnRefreshListener(mPresenter::exceptionInformation);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载,请稍后...");
        dialog.setCancelable(false);
        mPresenter.exceptionInformation();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zaitao;
    }


    @Override
    public Context getContext() {
        return this;
    }


    @OnItemClick(R.id.mZaitaoRenyuan)
    void itemClick(int pos){
//        PushInfo.DataBean item=adapter.getItem(pos);
        Intent atLargeTrajectory=new Intent(this,PersonTrajectoryAnalysisActivity.class).putExtra("push",true);
//        atLargeTrajectory.putExtra("idNumber",item.getZtidcard());
        startActivity(atLargeTrajectory);
    }

    @Override
    public void changeData(List<PushInfo.DataBean> data) {
//        adapter.changeData(data);
    }

    @Override
    public void refreshOnly() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }
}