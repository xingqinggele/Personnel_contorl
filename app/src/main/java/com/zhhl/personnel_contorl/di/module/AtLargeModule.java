package com.zhhl.personnel_contorl.di.module;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.AtLargeContact;
import com.zhhl.personnel_contorl.mvp.model.AtLargeModel;
import com.zhhl.personnel_contorl.net.IModelInformation;
import com.zhhl.personnel_contorl.net.IModelInformationStaticProxy;


import dagger.Module;
import dagger.Provides;


/**
 * Created by miao on 2019/2/28.
 */

@Module
public class AtLargeModule {
    private AtLargeContact.View view;


    public AtLargeModule(AtLargeContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AtLargeContact.View provideAtLargeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AtLargeContact.Model provideAtLargeModel(Gson gson, OriginApp application, IModelInformation iModelInformation) {
        return new AtLargeModel(gson, application,new IModelInformationStaticProxy(iModelInformation));
    }
}