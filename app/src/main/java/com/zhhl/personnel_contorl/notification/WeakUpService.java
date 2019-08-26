package com.zhhl.personnel_contorl.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.zhhl.personnel_contorl.BuildConfig;
import com.zhhl.personnel_contorl.receiver.UnLockReceiver;
import com.zhhl.personnel_contorl.utils.NotificationUtils;


public class WeakUpService extends Service {
    public WeakUpService() {
    }

    AlarmManager alarmManager;
    PendingIntent notificationPendingIntent;
    PendingIntent heartBeatPendingIntent;
    public static final int req_heart_beat = 0x7f00ff12;
    public static final int req_weak_up = 0x7f00ff13;
    private static String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    private static String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    private static String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    private UnLockReceiver unLockReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        unLockReceiver = new UnLockReceiver();
        if (BuildConfig.push_version >= 1)
            startForeground(-1, NotificationUtils.foreground(this, "sp-01"));

        notificationPendingIntent = PendingIntent.getService(this, req_weak_up, new Intent(this, NotificationService.class).putExtra("access", -1), PendingIntent.FLAG_UPDATE_CURRENT);
        heartBeatPendingIntent = PendingIntent.getService(this, req_heart_beat, new Intent(this, HeartBeatService.class).putExtra("access", -1), PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 60 * 1000, notificationPendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1* 60 * 1000, heartBeatPendingIntent);
        IntentFilter intentFilter = new IntentFilter(ACTION_BATTERY_CHANGED);
        IntentFilter intentFilter2 = new IntentFilter(ACTION_SCREEN_ON);
        IntentFilter intentFilter3 = new IntentFilter(ACTION_SCREEN_OFF);
        registerReceiver(unLockReceiver, intentFilter);
        registerReceiver(unLockReceiver, intentFilter2);
        registerReceiver(unLockReceiver, intentFilter3);
        NotificationUtils.startIntent(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.e( "onStartCommand: ","aad" );


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(unLockReceiver);
        if (BuildConfig.push_version >= 2)
            NotificationUtils.startIntent(this);
    }
}
