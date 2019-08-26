package com.zhhl.personnel_contorl.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.adapter.CunguanGuijiAdapter;
import com.zhhl.personnel_contorl.adapter.HorName;
import com.zhhl.personnel_contorl.adapter.YearStringAdapter;
import com.zhhl.personnel_contorl.common.BasicActivity;
import com.zhhl.personnel_contorl.data.CunguanGuijiWrapper;
import com.zhhl.personnel_contorl.data.Cunguanguiji;
import com.zhhl.personnel_contorl.data.Cunguanrenyuan;
import com.zhhl.personnel_contorl.data.Cunguanzhixi;
import com.zhhl.personnel_contorl.data.StringFlag;
import com.zhhl.personnel_contorl.net.HttpTools;
import com.zhhl.personnel_contorl.net.IModelInformation;
import com.zhhl.personnel_contorl.utils.DateUtil;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CunguanguijiActivity extends BasicActivity {
    private Cunguanrenyuan.CunguanrenyuanBean data;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.year)
    Spinner year;
    @BindView(R.id.mGuiji)
    ListView mGuiji;
    @BindView(R.id.linearLayout2)
    RecyclerView names;
    @BindView(R.id.nodata)
    TextView nodata;
    private ProgressDialog dialog;
    private final ArrayList<String> sfzhs = new ArrayList<>();
    private String sfzh;
    private Gson gson = new Gson();
    private final CunguanGuijiAdapter mAdapter = new CunguanGuijiAdapter();
    private HorName horName;
    private IModelInformation iModelInformation;

    private final HashMap<String, ArrayList<CunguanGuijiWrapper>> nameMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        ButterKnife.bind(this);

        year.setAdapter(years);
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mGuiji.setSelection(sitem.get(years.getItem(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        nodata.setText("暂无数据");
        iModelInformation = HttpTools.build(IModelInformation.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        horName = new HorName(this);
        names.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        names.setAdapter(horName);
        nameMap.put("全部", new ArrayList<>());
        nameMap.put("本人", new ArrayList<>());
        nameMap.put("关系人", new ArrayList<>());


        ArrayList<StringFlag> name = new ArrayList<>();
        name.add(new StringFlag("全部"));
        name.add(new StringFlag("本人"));
        name.add(new StringFlag("关系人"));
        horName.setNames(name);
        horName.setClick((v, pos) -> {

            ArrayList<CunguanGuijiWrapper> wrappers = nameMap.get(horName.getNames().get(pos).name);
            Collections.sort(wrappers);
            mAdapter.setData(wrappers);
            mGuiji.setSelection(0);
            parseData(mAdapter.getData());
            year.setSelection(0);
            if (wrappers.size() > 0) {
                nodata.setVisibility(View.GONE);
            } else {
                nodata.setVisibility(View.VISIBLE);
            }
        });
        setSupportActionBar(toolbar);
        mGuiji.setAdapter(mAdapter);
        data = getIntent().getParcelableExtra("data");
        this.name.setText(data.getXm());
        sfzh = data.getGmsfhm();
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载,请稍后...");
        dialog.setCancelable(false);

        getZhixi();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_zaitaoguiji;
    }


    private void getZhixi() {
        dialog.show();
        iModelInformation.cunguanzhixi(sfzh)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::cunguanzhixi, this::Err, this::complete)
                .isDisposed();
    }

    private void cunguanzhixi(Cunguanzhixi cunguanzhixi) {
        List<Cunguanzhixi.HunyinBean> hunyin = cunguanzhixi.getHunyin();
        for (Cunguanzhixi.HunyinBean hb : hunyin) {
            if (sfzhs.contains(hb.getCertNumMan()) || sfzhs.contains(hb.getCertNumWoman()))
                continue;
            if (hb.getCertNumWoman().equals(sfzh)) {
                sfzhs.add(hb.getCertNumMan());
            } else {
                sfzhs.add(hb.getCertNumWoman());
            }
        }
        List<Cunguanzhixi.RenkouBean> renkou = cunguanzhixi.getRenkou();
        for (Cunguanzhixi.RenkouBean rb : renkou) {
            if (sfzhs.contains(rb.getGmsfhm()))
                continue;
            sfzhs.add(rb.getGmsfhm());
        }
        getMyGuiji();
        getZhixiGuiji();
    }

    private void getZhixiGuiji() {
        dialog.show();
        for (String s : sfzhs) {
            if (!s.equals(sfzh))
                iModelInformation.cunguanguiji(s)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::zhixiGuiji, this::Err, this::complete)
                        .isDisposed();
        }
    }

    private void zhixiGuiji(Cunguanguiji zaitaoguiji) {
        ArrayList<CunguanGuijiWrapper> wrappers = transitionWrapper(zaitaoguiji);
        nameMap.get("全部").addAll(wrappers);
        nameMap.get("关系人").addAll(wrappers);
        mAdapter.addData(wrappers);
        dialog.dismiss();
        parseData(mAdapter.getData());
    }

    private void selfGuiji(Cunguanguiji zaitaoguiji) {
        ArrayList<CunguanGuijiWrapper> wrappers = transitionWrapper(zaitaoguiji);
        nameMap.get("全部").addAll(wrappers);
        nameMap.get("本人").addAll(wrappers);
        mAdapter.addData(wrappers);
        dialog.dismiss();
        parseData(mAdapter.getData());
    }

    private ArrayList<CunguanGuijiWrapper> transitionWrapper(Cunguanguiji cunguanguiji) {
        ArrayList<CunguanGuijiWrapper> wrappers = new ArrayList<>();
        List<Cunguanguiji.BudongchanBean> budongchan = cunguanguiji.getBudongchan();
        List<Cunguanguiji.CheliangBean> cheliang = cunguanguiji.getCheliang();
        List<Cunguanguiji.GetixinxiBean> getixinxi = cunguanguiji.getGetixinxi();
        List<Cunguanguiji.QiyexinxiBean> qiyexinxi = cunguanguiji.getQiyexinxi();
        List<Cunguanguiji.ShengneifangchanBean> shengneifangchan = cunguanguiji.getShengneifangchan();
        List<Cunguanguiji.WeifafanzuiBean> weifafanzui = cunguanguiji.getWeifafanzui();

        for (Cunguanguiji.BudongchanBean b : budongchan) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        for (Cunguanguiji.CheliangBean b : cheliang) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        for (Cunguanguiji.GetixinxiBean b : getixinxi) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        for (Cunguanguiji.QiyexinxiBean b : qiyexinxi) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        for (Cunguanguiji.ShengneifangchanBean b : shengneifangchan) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        for (Cunguanguiji.WeifafanzuiBean b : weifafanzui) {
            CunguanGuijiWrapper cunguanGuijiWrapper = new CunguanGuijiWrapper(b);
            wrappers.add(cunguanGuijiWrapper);
        }
        return wrappers;
    }

    private void getMyGuiji() {
        dialog.show();
        iModelInformation.cunguanguiji(sfzh)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::selfGuiji, this::Err, this::complete)
                .isDisposed();
    }

    private void complete() {
        if (nameMap.get("全部").size() == 0) {
            nodata.setVisibility(View.VISIBLE);
        } else {
            nodata.setVisibility(View.GONE);
        }
    }

    private void Err(Throwable throwable) {
        throwable.printStackTrace();
        dialog.dismiss();
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        if (nameMap.get("全部").size() == 0) {
            nodata.setVisibility(View.VISIBLE);
        } else {
            nodata.setVisibility(View.GONE);
        }
    }

    private final YearStringAdapter years = new YearStringAdapter();
    private final HashMap<String, Integer> sitem = new HashMap<>();

    private void parseData(ArrayList<CunguanGuijiWrapper> data) {
        int current = Integer.MAX_VALUE;

        int yearInt = 0;
        sitem.clear();
        ArrayList<String> year = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (current > (yearInt = Integer.parseInt(DateUtil.format("yyyy", data.get(i).getTime())))) {
                current = yearInt;
                yearInt = 0;
                year.add("" + current);
                sitem.put("" + current, i);
            }
        }
        years.setData(year);
    }

}
