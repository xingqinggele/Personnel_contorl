package com.zhhl.personnel_contorl.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.notification.HeartBeatService;
import com.zhhl.personnel_contorl.notification.NotificationService;
import com.zhhl.personnel_contorl.notification.WeakUpService;


public class NotificationUtils {
    public static Notification foreground(Context context, String channelId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
        builder.setContentTitle("线索推送正在运行中");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setAutoCancel(false);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0x7f, new Intent(context, WeakUpService.class), PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);
        return builder.build();
    }

    public static void startIntent(Context context) {

        Intent weak = new Intent(context, WeakUpService.class);
        Intent notification = new Intent(context, NotificationService.class).putExtra("access", -1);
        Intent heartbeat = new Intent(context, HeartBeatService.class);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(weak);
            context.startForegroundService(notification);
            context.startForegroundService(heartbeat);
        } else {
            context.startService(weak);
            context.startService(notification);
            context.startService(heartbeat);
        }

    }
}
