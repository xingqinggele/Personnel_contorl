package com.zhhl.personnel_contorl.mvp.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.xdja.uaac.api.TokenCallback;
import com.xdja.uaac.api.UaacApi;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.common.BaseMvpActivity;
import com.zhhl.personnel_contorl.di.component.AppComponent;
import com.zhhl.personnel_contorl.di.component.DaggerSplashComponent;
import com.zhhl.personnel_contorl.di.module.SplashModule;
import com.zhhl.personnel_contorl.mvp.contacts.SplashContract;
import com.zhhl.personnel_contorl.mvp.presenter.SplashPresenter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by miao on 2018/9/7.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashContract.View {
    private OkHttpClient okHttpClient = new OkHttpClient();

    //
//    @BindView(R.id.appName)
//    TextView appName;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.information)
    TextView information;
    private boolean finish;
    @BindView(R.id.root)
    ConstraintLayout splashView;
    @BindView(R.id.indicator)
    ProgressBar indicator;

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        DaggerSplashComponent
                .builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this)) //请将SplashModule()第一个首字母改为小写
                .build()
                .inject(this);
        getDaataa();
    }

    @Override
    public void dismissIndicator() {
        indicator.setVisibility(View.INVISIBLE);
        Snackbar.make(splashView, "您的账户没有在系统注册,请与管理员联系", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showMain() {
//        修改了
//        startActivity(new Intent(this, MainActivity.class));
        startActivity(new Intent(this, PetitionActivity.class));
        finish();
    }

    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        description.setText("①定制模型对数据进行专项分析\n" +
//                "②智能推送出重点人员异常轨迹信息");
//
//        information.setText("如需开通权限请联系系统管理员\n" +
//                "吉林省智慧互联信息科技有限公司\n" +
//                "技术联系电话18043134285");
        UaacApi.getToken(this, new TokenCallback() {
            @Override
            public void onSuccess(String token, boolean b) {
                if (b)
                    mPresenter.login(token);
                else
                    new Handler(Looper.getMainLooper()).postDelayed(() -> mPresenter.login(token), 5000);
            }

            @Override
            public void onError(String s) {
                if (s.equals("票据不存在")) {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> UaacApi.getToken(SplashActivity.this, this), 2000);
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public Context getContext() {
        return this;
    }


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

                Log.e("返回值", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String aa = response.body().string();
                Log.d("aaa", aa);
            }
        });
    }

}