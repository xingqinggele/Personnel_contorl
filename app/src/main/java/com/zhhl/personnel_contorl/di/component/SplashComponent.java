package com.zhhl.personnel_contorl.di.component;


import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.di.module.SplashModule;
import com.zhhl.personnel_contorl.mvp.view.activities.SplashActivity;

import dagger.Component;

/**
 * Created by miao on 2018/9/7.
 */

@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}