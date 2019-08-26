package com.zhhl.personnel_contorl.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.adapter.NotificationAdapter;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.support.MListView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnlockActivity extends Activity {

    private ArrayList<PushInfo.DataBean> dataBeans = new ArrayList<>();
    private MListView mList;
    private NotificationAdapter adapter;

    @BindView(R.id.mRoot)
    LinearLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_unlock);
        ButterKnife.bind(this);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Drawable drawable = wallpaperManager.getDrawable();
        mRoot.setBackground(drawable);
        dataBeans.addAll(getIntent().getParcelableArrayListExtra("data"));
        Log.e( "onCreate: ", "data size:"+dataBeans.size());
        mList = findViewById(R.id.mList);
        adapter = new NotificationAdapter();
        adapter.addOnItemClickListener(v -> finish());
        adapter.setData(dataBeans);
        mList.setAdapter(adapter);
        adapter.setCallFinish(UnlockActivity.this::finish);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setTurnScreenOn(true);
            setShowWhenLocked(true);
        }

        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            keyguardManager.requestDismissKeyguard(this, new KeyguardManager.KeyguardDismissCallback() {
                @Override
                public void onDismissError() {
                    super.onDismissError();
                }

                @Override
                public void onDismissSucceeded() {
                    super.onDismissSucceeded();
                }

                @Override
                public void onDismissCancelled() {
                    super.onDismissCancelled();
                }
            });
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }
}
