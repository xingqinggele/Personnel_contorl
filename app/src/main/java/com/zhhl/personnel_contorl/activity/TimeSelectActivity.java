package com.zhhl.personnel_contorl.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.utils.DateUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimeSelectActivity extends AppCompatActivity {

    @BindView(R.id.dateStart)
    TextView dateStart;
    @BindView(R.id.dateEnd)
    TextView dateEnd;
    @BindView(R.id.mQuery)
    TextView mQuery;


    private String startDate = "";
    private String endDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        setContentView(R.layout.activity_time_select);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.dateStart)
    public void onDateStartClicked() {
        getDate(true).show();
    }

    @OnClick(R.id.dateEnd)
    public void onDateEndClicked() {
        getDate(false).show();
    }

    @OnClick(R.id.mQuery)
    public void onMQueryClicked() {

        if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate)) {
            Toast.makeText(this, "请设置起始日期", Toast.LENGTH_SHORT).show();
            return;
        }

        if (DateUtil.parseDate("yyyy-MM-dd", startDate) > DateUtil.parseDate("yyyy-MM-dd", endDate)) {
            Toast.makeText(this, "开始日期不可以早于结束日期,请重新设置", Toast.LENGTH_SHORT).show();
            startDate = "";
            endDate = "";
            dateEnd.setText("请设置结束日期");
            dateStart.setText("请设置开始日期");
            return;
        }

        if (DateUtil.parseDate("yyyy-MM-dd", startDate) > System.currentTimeMillis() || DateUtil.parseDate("yyyy-MM-dd", endDate) > System.currentTimeMillis()) {
            Toast.makeText(this, "日期范围不可以超过今天,请重新设置", Toast.LENGTH_SHORT).show();
            startDate = "";
            endDate = "";
            dateEnd.setText("请设置结束日期");
            dateStart.setText("请设置开始日期");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("start", startDate);
        intent.putExtra("end", endDate);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();

    }

    private DatePickerDialog getDate(boolean start) {
        GregorianCalendar calendar = new GregorianCalendar();

        return new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            GregorianCalendar calendar1 = new GregorianCalendar();
            calendar1.set(year, month, dayOfMonth);
            if (start) {
                startDate = DateUtil.format("yyyy-MM-dd", calendar1.getTimeInMillis());
                dateStart.setText(startDate);
            } else {
                endDate = DateUtil.format("yyyy-MM-dd", calendar1.getTimeInMillis());
                dateEnd.setText(endDate);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}
