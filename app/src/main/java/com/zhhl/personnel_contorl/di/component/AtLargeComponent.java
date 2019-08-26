package com.zhhl.personnel_contorl.di.component;

import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.di.module.AtLargeModule;
import com.zhhl.personnel_contorl.mvp.view.activities.AtLargeActivity;


import dagger.Component;

/**
 * Created by miao on 2019/2/28.
 */

@ActivityScope
@Component(modules = AtLargeModule.class, dependencies = AppComponent.class)
public interface AtLargeComponent {
    void inject(AtLargeActivity activity);
}