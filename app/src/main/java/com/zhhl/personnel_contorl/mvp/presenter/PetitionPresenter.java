package com.zhhl.personnel_contorl.mvp.presenter;


import com.zhhl.personnel_contorl.common.BasePresenter;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.PetitionContact;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by miao on 2019/2/28.
 */

@ActivityScope
public class PetitionPresenter extends BasePresenter<PetitionContact.Model, PetitionContact.View> {
    private OriginApp mApplication;

    @Inject
    public PetitionPresenter(PetitionContact.Model model, PetitionContact.View rootView, OriginApp application) {
        super(model, rootView);
        this.mApplication = application;
    }

    public void exceptionInformation() {
        mModel.exceptionPetition()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::exceptionPetition, this::onError, this::onComplete)
                .isDisposed();
    }

    private void exceptionPetition(PushInfo info) {
        mRootView.changeData(info.getData());
        mRootView.refreshOnly();
        mRootView.dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        mRootView.refreshOnly();
        mRootView.dismiss();
    }


}
