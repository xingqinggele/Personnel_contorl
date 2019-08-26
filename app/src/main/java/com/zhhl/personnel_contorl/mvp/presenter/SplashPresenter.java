package com.zhhl.personnel_contorl.mvp.presenter;

import com.xdja.sslvpn.api.VpnApi50Impl;
import com.zhhl.personnel_contorl.app.App;
import com.zhhl.personnel_contorl.common.BasePresenter;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.LoginBean;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.SplashContract;
import com.zhhl.personnel_contorl.net.HttpTools;
import com.zhhl.personnel_contorl.net.ILogUploadImpl;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by miao on 2018/9/7.
 */

@ActivityScope
public class SplashPresenter extends BasePresenter<SplashContract.Model, SplashContract.View> {
    private OriginApp mApplication;

    @Inject
    public SplashPresenter(SplashContract.Model model, SplashContract.View rootView
            , OriginApp application) {
        super(model, rootView);
        this.mApplication = application;
    }


    public void login(String token) {
        HttpTools.buildLogin()
                .login(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::callResult, this::onError, this::onComplete)
                .isDisposed();
    }

    public void onError(Throwable throwable) {
        super.onError(throwable);
    }

    private void callResult(LoginBean loginBean) {
        App.app().setUserInfo(loginBean);
        App.app().setLogReport(new ILogUploadImpl(new VpnApi50Impl(mApplication)));
        mModel.checkPermission(loginBean.getUserInfo().getCode(), mApplication.getPackageName())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::checkResult, this::onError, this::onComplete)
                .isDisposed();
//        mRootView.showMain();

    }

    private void checkResult(boolean o) {
        if (o)
            mRootView.showMain();
        else
            mRootView.dismissIndicator();
    }
}
