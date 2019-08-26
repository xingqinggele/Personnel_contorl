package com.zhhl.personnel_contorl.common;

import android.Manifest;
import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.gson.Gson;
import com.xdja.sslvpn.api.VpnApi50;
import com.xdja.sslvpn.api.VpnApi50Impl;
import com.zhhl.personnel_contorl.BuildConfig;
import com.zhhl.personnel_contorl.R;
import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.utils.DateUtil;
import com.zhhl.personnel_contorl.utils.MacUtils;


import java.util.List;

public class TestDataActivity extends AppCompatActivity {
    private Gson gson;
    private TelephonyManager telephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_data);
        gson = new Gson();

        VpnApi50 vpn = new VpnApi50Impl(this);
//        vpn.start();
        Log.e("userId: ", vpn.getCardID());
        Log.e("sn: ", vpn.getDefaultCertSN());
        Log.e("cardNo: ", App.app().getUserInfo().getUserInfo().getIdentifier());
        Log.e("phone: ", App.app().getUserInfo().getUserInfo().getMobile());
        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 120);
//            return;
        }
        String deviceId = telephonyManager.getDeviceId();
        String simOperator = telephonyManager.getSimOperator();
        Log.e("imei: ", deviceId);
        Log.e("operator: ", simOperator);
        Log.e("imsi: ", telephonyManager.getSubscriberId());
        String mobileMAC = MacUtils.getMobileMAC(this);
        Log.e("mac: ", mobileMAC);
        Log.e("ip: ", MacUtils.getIPAddress(this));
        Log.e("versionCode_Name: ", BuildConfig.VERSION_CODE + ":" + BuildConfig.VERSION_NAME);
        Log.e("model: ", Build.MODEL);
        Log.e("device: ", Build.DEVICE);
        Log.e("phoneNumber: ", ":" + telephonyManager.getLine1Number());
        Log.e("simNo: ", telephonyManager.getSimSerialNumber());

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningAppProcesses =
                activityManager.getRunningTasks(1);
        Log.e("currentActivityName: ", (runningAppProcesses.get(0).topActivity).flattenToShortString());
        Log.e("currentTime: ", DateUtil.format("yyyy-MM-dd HH:mm:ss.SSS",System.currentTimeMillis()));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,   String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == 120) {
            String deviceId = telephonyManager.getDeviceId();
            String simOperator = telephonyManager.getSimOperator();
            Log.e("onCreate: ", telephonyManager.getSubscriberId());
//        devices.
            Log.e("onCreate: ", deviceId);
            Log.e("onCreate: ", simOperator);
        }
    }
}
