package com.zhhl.personnel_contorl.net;


import com.zhhl.personnel_contorl.data.PushInfo;

import io.reactivex.Observable;

public class IHeartStaticProxy implements IHeartbeat {

    private IHeartbeat source;
    private ILogUploadImpl logUpload;

    public IHeartStaticProxy(IHeartbeat source, ILogUploadImpl logUpload) {
        this.source = source;
        this.logUpload = logUpload;
    }

    @Override
    public Observable<PushInfo> heartbeat(String code) {
        Observable<PushInfo> heartbeat = source.heartbeat(code);
        logUpload.log("{\"jh\":\""+code+"\"}");
        return heartbeat;
    }
}
