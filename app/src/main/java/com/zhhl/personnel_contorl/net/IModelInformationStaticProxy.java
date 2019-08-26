package com.zhhl.personnel_contorl.net;


import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.data.Cunguanguiji;
import com.zhhl.personnel_contorl.data.Cunguanrenyuan;
import com.zhhl.personnel_contorl.data.Cunguanzhixi;
import com.zhhl.personnel_contorl.data.PushInfo;

import io.reactivex.Observable;

public class IModelInformationStaticProxy implements IModelInformation {

    private IModelInformation information;


    private ILogUploadImpl logUpload;

    public IModelInformationStaticProxy(IModelInformation iModelInformation) {
        this.information = iModelInformation;
        this.logUpload = App.app().getLogReport();


    }

    @Override
    public Observable<Cunguanrenyuan> cunguanmingdan() {
        return null;
    }

    @Override
    public Observable<Cunguanzhixi> cunguanzhixi(String sfzh) {
        return null;
    }

    @Override
    public Observable<Cunguanguiji> cunguanguiji(String sfzh) {
        return null;
    }

    @Override
    public Observable<PushInfo> exceptionAtLarge() {
        Observable<PushInfo> pushInfoObservable = information.exceptionAtLarge();
        logUpload.log("{}");
        return pushInfoObservable;
    }

    @Override
    public Observable<PushInfo> exceptionPetition() {
        Observable<PushInfo> pushInfoObservable = information.exceptionPetition();
        logUpload.log("{}");
        return pushInfoObservable;
    }

    @Override
    public Observable<Boolean> checkPermission(String jinghao, String dizhi) {
        return information.checkPermission(jinghao,dizhi);
    }

    @Override
    public Observable<PushInfo> exceptionConcernedWithDrugs() {
        return information.exceptionConcernedWithDrugs();
    }
}
