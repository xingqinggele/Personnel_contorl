package com.zhhl.personnel_contorl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.mvp.view.activities.AtLargeActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.ConcernedWithDrugsActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.PetitionActivity;
import com.zhhl.personnel_contorl.notification.HeartBeatService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static boolean isLaunched;
    @BindView(R.id.shangfang)
    ImageView shangfang;
    @BindView(R.id.concernedWithDrugs)
    ImageView concernedWithDrugs;
    @BindView(R.id.zaitao)
    ImageView zaitao;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.cunguan)
    ImageView imageView4;


    public static void startCurrent(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        bindService(new Intent(this, HeartBeatService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
//                try {
//
////                    IPoliceCodeInterface.Stub.asInterface(service).set(App.app().getUserInfo().getUserInfo().getCode());
//                    unbindService(this);
//                    isLaunched = true;
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);

    }


    @OnClick({R.id.shangfang, R.id.concernedWithDrugs, R.id.zaitao, R.id.imageView5, R.id.cunguan})
    public void onViewClicked(View view) {

        Intent intent;
        switch (view.getId()) {
            case R.id.shangfang:
                intent = new Intent(this, PetitionActivity.class);
                startActivity(intent);
                break;
            case R.id.concernedWithDrugs:
                intent = new Intent(this, ConcernedWithDrugsActivity.class);
                startActivity(intent);
                break;
            case R.id.zaitao:
                intent = new Intent(this, AtLargeActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView5:
                Toast.makeText(this, "正在开发中,敬请期待....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cunguan:
                Toast.makeText(this, "正在开发中,敬请期待....", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        stopService(new Intent( this,NotificationService.class));
    }
}
