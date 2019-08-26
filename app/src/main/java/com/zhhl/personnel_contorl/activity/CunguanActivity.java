package com.zhhl.personnel_contorl.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.adapter.CunguanAdapter;
import com.zhhl.personnel_contorl.common.BasicActivity;
import com.zhhl.personnel_contorl.data.Cunguanrenyuan;
import com.zhhl.personnel_contorl.net.HttpTools;
import com.zhhl.personnel_contorl.net.IModelInformation;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CunguanActivity extends BasicActivity {

    @BindView(R.id.mZaitaoRenyuan)
    ListView mCunguanrenyuan;
    private IModelInformation iModelInformation;
    Gson gson = new Gson();
    private ProgressDialog dialog;
    private final CunguanAdapter mAdapter = new CunguanAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        ButterKnife.bind(this);
        iModelInformation = HttpTools.build(IModelInformation.class);
        mCunguanrenyuan.setAdapter(mAdapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载,请稍后...");
        dialog.setCancelable(false);
        queryCunguanrenyuan();

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_zaitao;
    }

    private void queryCunguanrenyuan() {
        dialog.show();

        iModelInformation.cunguanmingdan()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::cunguanrenyuan, this::Err, this::complete)
                .isDisposed();

    }

    @OnItemClick(R.id.mZaitaoRenyuan)
    void itemClick(int pos) {
        Cunguanrenyuan.CunguanrenyuanBean item = mAdapter.getItem(pos);
        Intent zaitaoguiji = new Intent(this, CunguanguijiActivity.class);
        zaitaoguiji.putExtra("data", item);
        startActivity(zaitaoguiji);
    }

    private void complete() {
        dialog.dismiss();
    }

    private void Err(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    private void cunguanrenyuan(Cunguanrenyuan zaitaorenyuan) {
        mAdapter.setData((ArrayList<Cunguanrenyuan.CunguanrenyuanBean>) zaitaorenyuan.getCunguanrenyuan());
        dialog.dismiss();
    }
}
