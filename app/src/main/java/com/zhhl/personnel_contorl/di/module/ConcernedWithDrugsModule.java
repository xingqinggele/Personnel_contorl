package com.zhhl.personnel_contorl.di.module;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.ConcernedWithDrugsContact;
import com.zhhl.personnel_contorl.mvp.model.ConcernedWithDrugsModel;
import com.zhhl.personnel_contorl.net.IModelInformation;


import dagger.Module;
import dagger.Provides;


/**
 * Created by miao on 2019/4/1.
 */

@Module
public class ConcernedWithDrugsModule {
    private ConcernedWithDrugsContact.View view;


    public ConcernedWithDrugsModule(ConcernedWithDrugsContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ConcernedWithDrugsContact.View provideConcernedWithDrugsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ConcernedWithDrugsContact.Model provideConcernedWithDrugsModel(Gson gson, OriginApp application, IModelInformation iModelInformation) {
        return new ConcernedWithDrugsModel(gson, application, iModelInformation);
    }
}