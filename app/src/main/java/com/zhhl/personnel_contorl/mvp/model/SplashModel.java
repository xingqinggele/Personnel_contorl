package com.zhhl.personnel_contorl.mvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.BaseModel;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.mvp.contacts.SplashContract;
import com.zhhl.personnel_contorl.net.IModelInformation;

import io.reactivex.Observable;

/**
 * Created by miao on 2018/9/7.
 */

public class SplashModel extends BaseModel implements SplashContract.Model {

    private final IModelInformation iModel;

    public SplashModel(Gson gson, OriginApp application, IModelInformation iModel) {
        super(application, gson);
        this.iModel = iModel;
    }


    @Override
    public Observable<Boolean> checkPermission(String code, String requiredId) {
        Log.e("checkPermission: ", requiredId);
        return iModel.checkPermission(code, requiredId);
    }
}

