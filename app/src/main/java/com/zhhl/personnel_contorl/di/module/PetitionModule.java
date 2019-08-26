package com.zhhl.personnel_contorl.di.module;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.PetitionContact;
import com.zhhl.personnel_contorl.mvp.model.PetitionModel;
import com.zhhl.personnel_contorl.net.IModelInformation;
import com.zhhl.personnel_contorl.net.IModelInformationStaticProxy;


import dagger.Module;
import dagger.Provides;


/**
 * Created by miao on 2019/2/28.
 */

@Module
public class PetitionModule {
    private PetitionContact.View view;


    public PetitionModule(PetitionContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PetitionContact.View providePetitionView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PetitionContact.Model providePetitionModel(Gson gson, OriginApp application, IModelInformation iModelInformation) {
        return new PetitionModel(gson, application, new IModelInformationStaticProxy(iModelInformation));
    }
}