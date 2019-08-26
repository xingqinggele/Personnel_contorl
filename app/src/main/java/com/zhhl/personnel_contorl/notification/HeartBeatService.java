package com.zhhl.personnel_contorl.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;


import com.zhhl.personnel_contorl.BuildConfig;
import com.zhhl.personnel_contorl.IPoliceCodeInterface;
import com.zhhl.personnel_contorl.data.Heartbeat;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.net.HttpTools;
import com.zhhl.personnel_contorl.net.IHeartbeat;
import com.zhhl.personnel_contorl.utils.NotificationUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HeartBeatService extends Service {
    private String code;

    private PoliceCodeStub binder;

    public class PoliceCodeStub extends IPoliceCodeInterface.Stub
    {


        @Override
        public void set(String code) throws RemoteException {
            if (!TextUtils.isEmpty(code))
                HeartBeatService.this.code = code;
        }

        @Override
        public String get() throws RemoteException {
            return code;
        }
    }

    public HeartBeatService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.push_version >= 1)
            startForeground(-1, NotificationUtils.foreground(this, "sp-01"));


    }

    @Override
    public IBinder onBind(Intent intent) {
        if (binder == null) binder = new PoliceCodeStub();
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        String code = intent.getStringExtra("code");
//        if (!TextUtils.isEmpty(code)) {
//            this.code = code;
//        }
        heartbeat();
        return START_STICKY;
    }

    private void heartbeat() {
        Log.e("heartbeat: ", "will push " + code);
        if (!TextUtils.isEmpty(code))
            HttpTools.build(IHeartbeat.class).heartbeat(code)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::res2, this::onErr, this::onComplete)
                    .isDisposed();
    }

    private void onErr(Throwable throwable) {
        throwable.printStackTrace();
        startService(new Intent(this, NotificationService.class).putExtra("access", -1));
    }

    private void res(Heartbeat heartbeat) {
        startService(new Intent(this, NotificationService.class).putExtra("access", 200).putExtra("idNumber", heartbeat.getMsg().replaceAll("\r", "").replaceAll("\n", "")));
    }

    private void res2(Long heartbeat) {
        startService(new Intent(this, NotificationService.class).putExtra("access", 200).putExtra("idNumber", heartbeat + ""));
    }

    private void res2(PushInfo heartbeat) {
        for (int i = 0; i < heartbeat.getData().size(); i++)
            startService(new Intent(this, NotificationService.class).putExtra("access", 200).putExtra("data", heartbeat.getData().get(i)).putExtra("pos",i));
    }

    private void onComplete() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (BuildConfig.push_version >= 2)
            NotificationUtils.startIntent(this);
    }
}
