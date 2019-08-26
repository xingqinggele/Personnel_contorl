package com.zhhl.personnel_contorl.notification;

import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.util.LruCache;

import androidx.core.app.NotificationCompat;


import com.zhhl.personnel_contorl.BuildConfig;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.activity.UnlockActivity;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.mvp.view.activities.AtLargeActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.ConcernedWithDrugsActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.PersonTrajectoryAnalysisActivity;
import com.zhhl.personnel_contorl.mvp.view.activities.PetitionActivity;
import com.zhhl.personnel_contorl.utils.DateUtil;
import com.zhhl.personnel_contorl.utils.NotificationUtils;

import java.util.ArrayList;


public class NotificationService extends Service {
    NotificationManager notificationManager;
    NotificationChannel channel;
    private KeyguardManager keyguardManager;
    public static final int show_notification = 0x7f00ff11;

    private ArrayList<PushInfo.DataBean> dataBeans = new ArrayList<>();
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("onReceive: ", intent.getAction());
            if (dataBeans.size() > 0) {
                context.startActivity(new Intent(context, UnlockActivity.class).putExtra("data", new ArrayList<>(dataBeans)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                dataBeans.clear();
            }
        }
    };

    public NotificationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        PushInfo.DataBean item = new PushInfo.DataBean();
        item.setCreatetime("14:02");
        item.setTrackdiscription("ahahahahahahahahah");
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_SCREEN_ON));

        keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        cache.put(R.drawable.ic_launcher, BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("sp-01", "sp-01", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        if (BuildConfig.push_version >= 1)
            startForeground(-1, NotificationUtils.foreground(this, "sp-01"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int access = 0;
        int pos = 0;
        PushInfo.DataBean data = null;
        if (intent != null) {
            access = intent.getIntExtra("access", 0);
            pos = intent.getIntExtra("pos", 0);
            data = intent.getParcelableExtra("data");
        }
        long currentTime = System.currentTimeMillis() << 40;
        int notificationId = (int) (currentTime >> 40);

        boolean isDeviceLock;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            isDeviceLock = keyguardManager.isDeviceLocked();
        } else {
            isDeviceLock = keyguardManager.isKeyguardLocked();
        }


        if (data != null && !isDeviceLock) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "sp-01");
            builder.setContentTitle("您收到一条新消息");
//            builder.setContentText(data.getTrackdiscription());
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.drawable.push_0);

            builder.setContentIntent(makeActivityReStart(data.getZtidcard(), data.getTracktype(), notificationId << 8 + pos));
            Log.e("onStartCommand: ", "" + access);
            if ((access != -1 && access != 0))
                notificationManager.notify(notificationId << 8 + pos, builder.build());
        } else if (data != null && isDeviceLock) {
            data.setCreatetime(DateUtil.format("HH:mm", System.currentTimeMillis()));
            dataBeans.add(data);
        }

        return START_STICKY;
    }

//   220061197209190018
    private PendingIntent makeActivityReStart(String idNumber, String flag, int requestCode) {
//        Intent[] intents = new Intent[3];
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        Intent result = new Intent(this, PersonTrajectoryAnalysisActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("idNumber", idNumber).putExtra("push", true);
        taskStackBuilder.addParentStack(PersonTrajectoryAnalysisActivity.class);


////        intents[2] = new Intent(this, PersonTrajectoryAnalysisActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        intents[2] =Intent.makeRestartActivityTask(new ComponentName(this,PersonTrajectoryAnalysisActivity.class)).putExtra("idNumber", idNumber);
//
        switch (flag) {
            case "0":
                taskStackBuilder.addNextIntent(new Intent(this, AtLargeActivity.class));
                break;
            case "1":
                taskStackBuilder.addNextIntent(new Intent(this, PetitionActivity.class));
                break;
            case "2":
                taskStackBuilder.addNextIntent(new Intent(this, ConcernedWithDrugsActivity.class));
            default:
        }
        taskStackBuilder.addNextIntent(result);

        return taskStackBuilder.getPendingIntent(requestCode, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        if (BuildConfig.push_version >= 2)
            NotificationUtils.startIntent(this);
    }


    private LruCache<Integer, Bitmap> cache = new LruCache<Integer, Bitmap>(10) {
        @Override
        protected int sizeOf(Integer key, Bitmap value) {
            return value.getHeight() * value.getWidth();
        }

        @Override
        protected Bitmap create(Integer key) {
            return super.create(key);
        }
    };

}
