package com.zhhl.personnel_contorl.di.component;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.di.module.AppModule;
import com.zhhl.personnel_contorl.di.module.ClientModule;
import com.zhhl.personnel_contorl.di.module.NetworkModule;
import com.zhhl.personnel_contorl.net.IModelInformation;
import com.zhhl.personnel_contorl.net.ITrajectory;


import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {AppModule.class, ClientModule.class, NetworkModule.class})

public interface AppComponent {
    OriginApp application();

    Gson gson();

    OkHttpClient client();

    IModelInformation iModelInformation();

    ITrajectory iTrajectory();

}