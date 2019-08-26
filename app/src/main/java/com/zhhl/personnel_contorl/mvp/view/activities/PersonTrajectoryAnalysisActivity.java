package com.zhhl.personnel_contorl.mvp.view.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.activity.GxrTrajectoryActivity;
import com.zhhl.personnel_contorl.adapter.GxclAdapter;
import com.zhhl.personnel_contorl.adapter.GxrAdapter;
import com.zhhl.personnel_contorl.adapter.PersonAnalysisAdapter;
import com.zhhl.personnel_contorl.adapter.YearStringAdapter;
import com.zhhl.personnel_contorl.common.BaseMvpActivity;
import com.zhhl.personnel_contorl.data.GxclData;
import com.zhhl.personnel_contorl.data.PersonTrajectory;
import com.zhhl.personnel_contorl.data.Trajectory;
import com.zhhl.personnel_contorl.di.component.AppComponent;
import com.zhhl.personnel_contorl.mvp.contacts.PersonTrajectoryAnalysisContract;
import com.zhhl.personnel_contorl.mvp.presenter.PersonTrajectoryAnalysisPresenter;
import com.zhhl.personnel_contorl.utils.DateUtil;
import com.zhhl.personnel_contorl.utils.DialogUtils;
import com.zhhl.personnel_contorl.xinjia.Home_gen_opera_details_guige_Adapter;
import com.zhhl.personnel_contorl.xinjia.Peti_datalis_data;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 新加的注释、重点上访详情
 */
public class PersonTrajectoryAnalysisActivity extends BaseMvpActivity<PersonTrajectoryAnalysisPresenter> implements PersonTrajectoryAnalysisContract.View {
    private boolean self;

    private String sToday;
    private String _3day;
    private String _30day;

    private String start;
    private String end;

    private int date_flag = 1;
    private int gx_flag = 1;
    private int last_data_flag;


    private boolean push;
    private ProgressDialog mProgress;


//    @BindView(R.id.mTrajectoryYear)
//    TextView mTrajectoryYear;
//    修改的地方
//    @BindView(R.id.mTrajectoryName)
//    TextView mTrajectoryName;

    //    @BindView(R.id.mTrajectoryPush)
//    TextView mTrajectoryPush;
    @BindView(R.id.mTrajectoryList)
    ListView mTrajectoryList;
    @BindView(R.id.nodata)
    TextView nodata;

    //    修改的地方
    @BindView(R.id.nameWrapper)
    SimpleDraweeView nameWrapper;
//    ImageView nameWrapper;

    private static final int REQUEST_CODE = 100;
    private final GxrAdapter mGxrAdapter = new GxrAdapter(new ArrayList<>());
    private final GxclAdapter mGxclAdapter = new GxclAdapter(new ArrayList<>());
    private Home_gen_opera_details_guige_Adapter home_gen_opera_details_guige_adapter;
    private Peti_datalis_data peti_datalis_data;
    private List<Peti_datalis_data.GuijiBean> pet_list = new ArrayList<>();

    private OkHttpClient okHttpClient = new OkHttpClient();
//    private AlertDialog.Builder builder;
//    private ProgressDialog progressDialog;
//    private int choice;

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
//        DaggerPersonTrajectoryAnalysisComponent
//                .builder()
//                .appComponent(appComponent)
//                .personTrajectoryAnalysisModule(new PersonTrajectoryAnalysisModule(this))
//                .build()
//                .inject(this);


    }

    @Override
    protected void initData() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        getIntentData();
//        setDate();
        initView2();
        start = sToday;
        end = sToday;
        createRequestDialog();

        mProgress = new ProgressDialog(this);
//        dialog.setMessage("正在加载,请稍后...");
//        dialog.setCancelable(false);
        mProgress.setMessage("正在检索数据,请稍后....");
        mProgress.setCancelable(false);
        mProgress.show();

        clearAdapter();

        if (push) {
            start = "2018-01-01";
            end = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
        }
//        mPresenter.getMyTrajectory(start, end);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_trajectory_analysis;
    }


    @Override
    public void showRequestDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    @Override
    public void dismissRequestDialog() {
        dialog.dismiss();
    }

    @Override
    public void addData(ArrayList<PersonTrajectory> data) {
        adapter.add(data);
        mTrajectoryList.setAdapter(adapter);
        dismiss(adapter.getData());
    }

//    private void setDate() {
//        sToday = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
//        _3day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 2L * 24 * 3600 * 1000);
//        _30day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000);
//    }

    private void createRequestDialog() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载,请稍后....");
        dialog.setCancelable(false);
    }

    private void getIntentData() {
        String idNumber = getIntent().getStringExtra("idNumber");
        self = getIntent().getBooleanExtra("self", true);
//        mPresenter.setIdNumber(idNumber);
        push = getIntent().getBooleanExtra("push", false);
        getdata(idNumber);
    }

    @Override
    public void setTrajectoryName(String xm)
    {
//        mTrajectoryName.setText(xm);
    }

    @Override
    public void clearAdapter() {
        adapter.clear();
        mTrajectoryList.setAdapter(adapter);
    }

    @Override
    public void setGxrAdapter(ArrayList<PersonTrajectory> transitionWrapper) {
        mGxrAdapter.setData(transitionWrapper);
        mTrajectoryList.setAdapter(mGxrAdapter);
        dismiss(mGxrAdapter.getData());
    }

    @Override
    public void setGxclAdapter(GxclData o) {
        mGxclAdapter.setData(new ArrayList<>(o.getQscl()));
        mTrajectoryList.setAdapter(mGxclAdapter);
        dismiss(mGxclAdapter.getData());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            start = data.getStringExtra("start");
            end = data.getStringExtra("end");
            invokeGx2(start, end);
            dismiss(adapter.getData());
        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            parseLastFlag();
            Toast.makeText(this, "您取消了自定义时间查询", Toast.LENGTH_SHORT).show();
        }
    }

//    @OnClick(R.id.nameWrapper)
//    public void nameClick() {
//        if (mPresenter.getRenkou() == null) {
//            if (mProgress == null) mProgress = DialogUtils.createProgressDialog(this, "正在设置数据,请稍候");
//            mProgress.show();
//            return;
//        }
//        showUserData();
//    }

    private void dismiss(ArrayList data) {
        noDataIfNeed(data);
        mProgress.dismiss();

    }


    private ProgressDialog dialog;

    private final PersonAnalysisAdapter adapter = new PersonAnalysisAdapter(new ArrayList<>());
    private final YearStringAdapter years = new YearStringAdapter(new ArrayList<>());

    private void parseLastFlag() {
//        mTrajectoryYear.setText(yearData[last_data_flag - 1]);
    }

    private void initView2() {
//        if (!push) {
//            years.setData(new ArrayList<>(Arrays.asList(yearData)));
//            mTrajectoryYear.setText(yearData[0]);
//        }else {
//            mTrajectoryYear.setText("");
//        }
//        mTrajectoryList.setAdapter(adapter);
        mTrajectoryList.setOnItemClickListener((parent, views, position, id) -> {
            showCustomizeDialog();
//            if (gx_flag == 2) {
//                int type = mGxrAdapter.getItem(position).getType();
//                switch (type) {
//                    case 46:
//                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHbtx2());
//                        break;
//                    case 47:
//                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHctx2());
//                        break;
//                    case 48:
//                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getKctx2());
//                        break;
//                    case 49:
//                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getZstx2());
//                        break;
//                    case 50:
//                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHclz2());
//                        break;
//                }
//            }
        });
    }

    private void personTrajectoryTx(int type, ArrayList<? extends Parcelable> o) {
        startActivity(
                new Intent(PersonTrajectoryAnalysisActivity.this, GxrTrajectoryActivity.class)
                        .putExtra("type", type)
                        .putExtra("self", false)
                        .putExtra("data", o));
    }


    private void invokeGx2(String start, String end) {
        switch (gx_flag) {
            case 1:
                clearAdapter();
                mPresenter.getDataRangeWx(start, end);
                mPresenter.getMyTrajectory(start, end);
                break;
            case 2:
                clearAdapter();
                mPresenter.getGxrTrajectory2(start, end);
                break;
            case 3:
                clearAdapter();
                mPresenter.getGxclTrajectory();
                break;
            case 6:
                clearAdapter();
                mPresenter.getChangQuDi(start, end);
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    static class ViewHolder {
        @BindView(R.id.mList)
        ListView mList;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void showUserData() {
        if (self) {
            if (mPresenter.getRenkou() != null && mPresenter.getRenkou().size() > 0) {
                Trajectory.RenkouBean rk = this.mPresenter.getRenkou().get(0);
                AlertDialog alertDialog = DialogUtils.create(
                        this,
                        R.layout.dialog_user_info,
                        rk.getXm(),
                        rk.getXbdm(),
                        rk.getMzdm(),
                        rk.getXldm(),
                        rk.getGmsfhm(),
                        rk.getDzmc());
                alertDialog.show();
            }
        }
    }

    private void noDataIfNeed(ArrayList data) {
        if (data.size() == 0) {
            nodata.setVisibility(View.VISIBLE);
        } else {
            nodata.setVisibility(View.GONE);
        }
    }


    private void showCustomizeDialog() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(PersonTrajectoryAnalysisActivity.this);
        final View dialogView = LayoutInflater.from(PersonTrajectoryAnalysisActivity.this)
                .inflate(R.layout.dialog_customize, null);
        customizeDialog.setTitle("               ");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容

                    }
                });
        customizeDialog.show();
    }


    private void getdata(String id)
    {
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(50, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(50, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(50, TimeUnit.SECONDS)//设置写入超时时间
                .build();
        RequestBody body = new FormBody.Builder()
                .add("idcode",id)
                .build();
        Request.Builder builder = new Request.Builder();
            Log.e("人员详情", "人员列表详情接口开始请求了！！");

        Request request = builder.url("http://192.168.20.228:7103/sjcj/shangfang/select1").post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mProgress.dismiss();


                Log.e("返回值", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mProgress.dismiss();

                final String aa = response.body().string();
                Log.d("aaa", aa);
                //需要转化为实体对象
                new Thread() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                peti_datalis_data = JSON.parseObject(aa,Peti_datalis_data.class);
                                pet_list = peti_datalis_data.getGuiji();
                                home_gen_opera_details_guige_adapter = new Home_gen_opera_details_guige_Adapter(PersonTrajectoryAnalysisActivity.this,pet_list);
                                mTrajectoryList.setAdapter(home_gen_opera_details_guige_adapter);
                            }
                        });
                        super.run();
                    }
                }.start();
            }
        });
    }

}