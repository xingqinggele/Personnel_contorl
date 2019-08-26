package com.zhhl.personnel_contorl.common;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xdja.watermarklibrary.WaterMarkUtils;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.di.component.AppComponent;


import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        applyWaterShadow();
        ButterKnife.bind(this);
        componentInject();
        initData();
    }

    private void applyWaterShadow() {
        if (App.app().getUserInfo() != null)
            WaterMarkUtils.addWaterMark(this, App.app().getUserInfo().getUserInfo().getName() + " " + App.app().getUserInfo().getUserInfo().getCode(), 270 + 45, getResources().getColor(R.color.wt), 60);
    }

    protected abstract void initData();

    protected abstract int layoutId();

    private void componentInject() {
        setUpActivityComponent(((App) getApplication()).getAppComponent());
    }

    protected abstract void setUpActivityComponent(AppComponent appComponent);
}
