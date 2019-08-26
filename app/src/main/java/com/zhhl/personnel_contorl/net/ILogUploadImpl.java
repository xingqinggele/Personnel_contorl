package com.zhhl.personnel_contorl.net;

import android.util.Log;

import com.xdja.sslvpn.api.VpnApi50;
import com.xdja.sslvpn.api.VpnApi50Impl;
import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.data.LoginBean;
import com.zhhl.personnel_contorl.utils.MacUtils;


import io.reactivex.schedulers.Schedulers;

public class ILogUploadImpl {
    private ILogUpload iLogUpload;
    private VpnApi50 vpnApi50;

    public ILogUploadImpl(ILogUpload iLogUpload, VpnApi50 vpnApi50) {
        this.iLogUpload = iLogUpload;
        this.vpnApi50 = vpnApi50;
    }

    public ILogUploadImpl(VpnApi50Impl vpnApi50) {
        iLogUpload = HttpTools.build(ILogUpload.class, "http://192.168.20.228:7122/");//"http://192.168.20.228:7122/"
        this.vpnApi50 = vpnApi50;
    }


    public void log(String formatParams) {
        LoginBean.UserInfoBean userInfo = App.app().getUserInfo().getUserInfo();
        iLogUpload.upload(userInfo.getCode(), vpnApi50.getDefaultCertSN(), userInfo.getIdentifier(),
                "12", "1", "{}", "{}", "{}", "成功", MacUtils.getIPAddress(App.app()),
                "智能线索推送", formatParams, "{}", "0", "1",
                "500", "{}", "{}", "0", "{}", "0", String.valueOf(System.currentTimeMillis()))
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.computation())
                .subscribe(this::logres, this::err, this::complete)
                .isDisposed();
    }

    private void complete() {

    }

    private void err(Throwable throwable) {
        throwable.printStackTrace();
    }

    private void logres(Object o) {
        Log.e("logReport>>>: ", o.toString());
    }
}
