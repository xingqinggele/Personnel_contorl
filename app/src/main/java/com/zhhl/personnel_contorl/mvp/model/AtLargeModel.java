package com.zhhl.personnel_contorl.mvp.model;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.BaseModel;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.mvp.contacts.AtLargeContact;
import com.zhhl.personnel_contorl.net.IModelInformation;


import io.reactivex.Observable;

/**
 * Created by miao on 2019/2/28.
 */

public class AtLargeModel extends BaseModel implements AtLargeContact.Model {

    private final IModelInformation iModelInformation;

    public AtLargeModel(Gson gson, OriginApp application, IModelInformation iModelInformation) {
        super(application, gson);
        this.iModelInformation = iModelInformation;
    }


    @Override
    public Observable<PushInfo> exceptionAtLarge() {
        return iModelInformation.exceptionAtLarge();
    }
}

