package com.zhhl.personnel_contorl.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.zhhl.personnel_contorl.notification.WeakUpService;


public class UnLockReceiver extends BroadcastReceiver {

    private String TAG = UnLockReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(TAG, "onReceive: " + intent.getAction());
//        NotificationUtils.startIntent(context);
        Intent weak = new Intent(context, WeakUpService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(weak);
        } else {
            context.startService(weak);
        }
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
