package com.zhhl.personnel_contorl.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xdja.watermarklibrary.WaterMarkUtils;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.app.App;
/**
 * Created by miao on 2018/12/19.
 */
public abstract class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        if (App.app().getUserInfo() != null)
            WaterMarkUtils.addWaterMark(this, App.app().getUserInfo().getUserInfo().getName() + " " + App.app().getUserInfo().getUserInfo().getCode(), 270 + 45, getResources().getColor(R.color.wt), 60);

    }

    protected abstract int getContentLayout();

}
