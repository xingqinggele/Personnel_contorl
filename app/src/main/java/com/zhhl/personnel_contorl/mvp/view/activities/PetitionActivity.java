package com.zhhl.personnel_contorl.mvp.view.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.fastjson.JSON;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.adapter.PushTrajectoryAdapter;
import com.zhhl.personnel_contorl.common.BaseMvpActivity;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.di.component.AppComponent;
import com.zhhl.personnel_contorl.mvp.contacts.PetitionContact;
import com.zhhl.personnel_contorl.mvp.presenter.PetitionPresenter;
import com.zhhl.personnel_contorl.xinjia.Petitiondata;
import com.zhhl.personnel_contorl.xinjia.Xinjia_activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnItemClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by miao on 2019/2/28.
 */

/**
 * 重点上访人员界面
 */
public class PetitionActivity extends BaseMvpActivity<PetitionPresenter> implements PetitionContact.View, View.OnClickListener {
    private OkHttpClient okHttpClient = new OkHttpClient();

    @BindView(R.id.mZaitaoRenyuan)
    ListView mPetitionList;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refreshLayout;
    private ProgressDialog dialog;
    private final PushTrajectoryAdapter mAdapter = new PushTrajectoryAdapter();
    //    新加的
    @BindView(R.id.xinjia_btn)
    ImageView xianjia_btn;
    @BindView(R.id.search_input)
    EditText search_input;

    //工单List
    private List<Petitiondata.ZhongdianrenyuanBean> designOrderList = new ArrayList<Petitiondata.ZhongdianrenyuanBean>();
    //根据输入框内容查询到的List数据
    private List<Petitiondata.ZhongdianrenyuanBean> searchDesignOrderList = new ArrayList<Petitiondata.ZhongdianrenyuanBean>();

    private List<Petitiondata.ZhongdianrenyuanBean> ggg = new ArrayList<>();
    private Petitiondata lll;

    @Override
    protected void initData() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        xianjia_btn.setOnClickListener(this);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        //原先的刷新
//        refreshLayout.setOnRefreshListener(mPresenter::exceptionInformation);

        mPetitionList.setAdapter(mAdapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在检索数据,请稍后....");
        dialog.setCancelable(false);
        dialog.show();
        // 新加的刷新
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh()
            {
                getDaataa();
            }
        });
//        原先的刷新
//        refreshLayout.setRefreshing(true);
//        mPresenter.exceptionInformation();
        // 新加的
        search_input.addTextChangedListener(watcher);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zaitao;
    }

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
//        原先的
//        DaggerPetitionComponent
//                .builder()
//                .appComponent(appComponent)
//                .petitionModule(new PetitionModule(this)) //请将PetitionModule()第一个首字母改为小写
//                .build()
//                .inject(this);
        getDaataa();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnItemClick(R.id.mZaitaoRenyuan)
    void itemClick(int pos) {
        //原先的详情
        //PushInfo.DataBean item = mAdapter.getItem(pos);
        Petitiondata.ZhongdianrenyuanBean item = mAdapter.getItem(pos);
        Intent shangfangguiji = new Intent(this, PersonTrajectoryAnalysisActivity.class).putExtra("push", true);
        Log.d("number", item.getIdcode());
        shangfangguiji.putExtra("idNumber", item.getIdcode());

        startActivity(shangfangguiji);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xinjia_btn:
                Intent intent = new Intent(this, Xinjia_activity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void changeData(List<PushInfo.DataBean> data) {
//            原先的
        // mAdapter.changeData(data);

    }

    @Override
    public void refreshOnly() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void dismiss()
    {
        dialog.dismiss();
    }

    // 新加的获取输入数据
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            Log.d("11111", "beforeTextChanged: s = " + s + ", start = " + start + ", count = " + count + ", after = " + after);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("222", "onTextChanged: s = " + s + ", start = " + start + ", before = " + before + ", count = " + count);
            // 做搜索操作
            findDesignOrder(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d("33333", "afterTextChanged: " + s);
        }
    };

    // 新加的查询列表功能
    public void findDesignOrder(String searchString) {
        if (searchDesignOrderList.size() != 0) {
            searchDesignOrderList.clear();
        } else {
            if (searchString != null || searchString != "") {

                int length = designOrderList.size();
                for (int i = 0; i < length; i++) {
//工单编码
                    String orderCode = designOrderList.get(i).getIdcode();
                    if (orderCode.contains(searchString)) {
                        searchDesignOrderList.add(designOrderList.get(i));
                    }
//工单客户名称
                    String customName = designOrderList.get(i).getXm();
                    if (customName.contains(searchString)) {
                        searchDesignOrderList.add(designOrderList.get(i));
                    }
//.....可继续添加其他查询内容
                }
            }
//驱动工单列表页面GirdView适配器变化
            mAdapter.changeData(searchDesignOrderList);
            mAdapter.notifyDataSetChanged();
        }

    }

    // 新加的人员列表接口
    public void getDaataa() {
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(100, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(100, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(100, TimeUnit.SECONDS)//
                .build();
        RequestBody body = new FormBody.Builder()
                .build();
        Request.Builder builder = new Request.Builder();
        Log.e("人员列表", "人员列表接口开始请求了！！");
        Request request = builder.url("http://192.168.20.228:7103/sjcj/shangfang/push").post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                dialog.dismiss();
                Log.e("返回值", e.getMessage());
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dialog.dismiss();
                final String aa = response.body().string();
                Log.d("aaa", aa);
                //需要转化为实体对象
                new Thread() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshLayout.setRefreshing(false);
                                lll = JSON.parseObject(aa, Petitiondata.class);
                                ggg = lll.getZhongdianrenyuan();
                                mAdapter.changeData(ggg);
                                // 赋值list
                                designOrderList = ggg;

                            }
                        });
                        super.run();
                    }
                }.start();
            }
        });
    }

}