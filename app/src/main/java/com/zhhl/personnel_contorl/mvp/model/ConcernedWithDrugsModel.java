package com.zhhl.personnel_contorl.mvp.model;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.BaseModel;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.PushInfo;
import com.zhhl.personnel_contorl.mvp.contacts.ConcernedWithDrugsContact;
import com.zhhl.personnel_contorl.net.IModelInformation;

import io.reactivex.Observable;

/**
 * Created by miao on 2019/4/1.
 */

public class ConcernedWithDrugsModel extends BaseModel implements ConcernedWithDrugsContact.Model {

    private final IModelInformation iModelInformation;

    public ConcernedWithDrugsModel(Gson gson, OriginApp application, IModelInformation iModelInformation) {
        super(application, gson);
        this.iModelInformation = iModelInformation;
    }

    @Override
    public Observable<PushInfo> exceptionConcernedWithDrugs() {
        return iModelInformation.exceptionConcernedWithDrugs();
    }
}

