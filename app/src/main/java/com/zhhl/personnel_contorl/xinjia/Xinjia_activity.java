package com.zhhl.personnel_contorl.xinjia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.zhhl.personnel_contorl.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
 * Created by czy on 2019/8/13 16:35.
 */
public class Xinjia_activity extends Activity implements View.OnClickListener
{
    private OkHttpClient okHttpClient=new OkHttpClient();
//    @BindView(R.id.mConcernPeopleNameTv)
//    TextView mConcernPeopleNameTv;
//    @BindView(R.id.mConcernPeopleNameEt)
//    EditText mConcernPeopleNameEt;
    @BindView(R.id.mConcernPeopleIdCodeTv)
    TextView mConcernPeopleIdCodeTv;
    @BindView(R.id.mConcernPeopleIdCodeEt)
    EditText mConcernPeopleIdCodeEt;
    @BindView(R.id.mConcernTimeRangeTv)
    TextView mConcernTimeRangeTv;
    @BindView(R.id.mConcernTimeStart)
    Spinner mConcernTimeStart;
    @BindView(R.id.mConcernTimeEnd)
    Spinner mConcernTimeEnd;
    @BindView(R.id.mRequestTv)
    TextView mRequestTv;
    @BindView(R.id.mRequestEt)
    EditText mRequestEt;
    @BindView(R.id.commit)
    TextView commit;


    ProgressDialog progressDialog;
    private DateSelectAdapter dateStartAdapter;
    private DateSelectAdapter dateEndAdapter;
    private String startDate;
    private String endDate;
    private String dataMessage = "";
//
//
    private String idCode;
//    private String name;
    private String content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinjia_activity);
        ButterKnife.bind(this);
        commit.setOnClickListener(this);
        initAdapter();

//        mConcernPeopleNameTv.setText(Html.fromHtml("姓名<font color = red>*</>"));
        mConcernPeopleIdCodeTv.setText(Html.fromHtml("身份证号<font color = red>*</>"));
        mConcernTimeRangeTv.setText(Html.fromHtml("关注时限<font color = red>*</>"));
        mRequestTv.setText(Html.fromHtml("申请事由<font color = red>*</>"));
        mConcernTimeStart.setAdapter(dateStartAdapter);
        mConcernTimeEnd.setAdapter(dateEndAdapter);
        mConcernTimeStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("", "onItemSelected: " + position);
                onTimeStartPress(position);
                startDate = dateStartAdapter.getData().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mConcernTimeEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                endDate = dateEndAdapter.getData().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initAdapter() {
        GregorianCalendar calendar = new GregorianCalendar();
        ArrayList<String> strings = generateData(calendar.get(Calendar.YEAR), 1, 0);
        dateStartAdapter = new DateSelectAdapter(strings);
        dateEndAdapter = new DateSelectAdapter(strings);
    }


    private ArrayList<String> generateData(int year, int offsetMonth, int dateOffset) {
        if (offsetMonth <= 0) offsetMonth = 1;
        ArrayList<String> data = new ArrayList<>();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int date = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int month = gregorianCalendar.get(Calendar.MONTH);
        gregorianCalendar.set(Calendar.YEAR, year);
        String monthString;
        String dateString;
        for (int m = month; m <= month + offsetMonth + dateOffset; m++) {
            gregorianCalendar.set(Calendar.MONTH, m);
            if (m + 1 < 10)
                monthString = "0%d";
            else {
                monthString = "%d";
            }
            for (int i = 1; i <= gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                if (i < 10)
                    dateString = "0%d";
                else {
                    dateString = "%d";
                }

                System.out.printf("%d-%d\n", (m + 1) % 12 == 0 ? 12 : ((m + 1) % 12), i);
                data.add(String.format(Locale.CHINA, "%d-" + monthString + "-" + dateString, year, (m + 1) % 12 == 0 ? 12 : ((m + 1) % 12), i));
            }

        }

        for (int i = 1; i < date; i++) {
            data.remove(0);
        }

        for (String s :
                data) {
            System.out.println(s);
        }

        return data;
    }

    void onTimeStartPress(int id) {
        ArrayList<String> data = new ArrayList<>(dateStartAdapter.getData());
        for (int i = 0; i < id; i++) {
            data.remove(0);
        }
        dateEndAdapter.setData(data);
    }

    @Override
    public void onClick(View v) {
        boolean dataFlag = true;
        idCode = mConcernPeopleIdCodeEt.getText().toString();
//        name = mConcernPeopleNameEt.getText().toString();
        content = mRequestEt.getText().toString();

        switch (v.getId())
        {
            case R.id.commit:
//                if (name.equals("")) {
//                    dataFlag = false;
//                    dataMessage = "姓名不能为空";
//                }
                if (dataFlag && idCode.equals("")) {
                    dataFlag = false;
                    dataMessage = "身份证号不能为空";
                }
                if (dataFlag && content.equals("")) {
                    dataFlag = false;
                    dataMessage = "申请事由不能为空";
                }
                if (dataFlag && startDate == null || startDate.equals("")) {
                    dataFlag = false;
                    dataMessage = "请选择起始时间";
                }
                if (dataFlag && endDate == null || endDate.equals("")) {
                    dataFlag = false;
                    dataMessage = "请选择结束时间";
                }
                if (dataFlag)
                {
                    if (progressDialog == null)
                        progressDialog = new ProgressDialog(this);
                        progressDialog.setMessage("正在提交，请稍后...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        //todo applyPerson ----------------------------
//                        mPresent.caseRecord(idCode);
//                    IHeartbeat.IYdsp build = HttpTools.build(IHeartbeat.IYdsp.class);
//                    String save = build.save("测试", "206589", "220183199511111010", "请假申请", "2018-08-08", "2018-12-12");
//                    System.out.println(save);
                    getDaataa();
                }
                else
                {
                        Toast.makeText(this, dataMessage, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // 发送接口
    public void getDaataa()
    {
        RequestBody body = new FormBody.Builder()
                .add("sfz",idCode)
                .add("qqsj",endDate)
                .add("zzsj",startDate)
                .add("spsy",content)
                .build();
        Request.Builder builder=new Request.Builder();
        Log.e("这是提交的","啊啊啊啊啊");
        Request  request=builder.url("http://192.168.20.228:7103/sjcj/shangfang/addApproval").post(body).build();
//      Request  request=builder.url("http://192.168.20.228:7103/sjcj/shangfang/push").post(body).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                progressDialog.dismiss();
                Log.e("返回值",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                progressDialog.dismiss();
                String aa = response.body().string();
                Log.e("返回值",aa);
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run()
                            {
                                toastView(R.mipmap.psuccess_xinjia,aa);
                                setResult(1);
                                finish();
                            }
                        });
                        super.run();
                    }
                }.start();
            }
        });
    }


    /**
     * 显示图片的Toast
     * @param view
     */
    public void toastView(int view,String test)
    {
        Toast toast = Toast.makeText(this,test, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(this);
        imageCodeProject.setImageResource(view);
//		toastView.setRotationX(180);  //绕X轴翻转180度
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

}
