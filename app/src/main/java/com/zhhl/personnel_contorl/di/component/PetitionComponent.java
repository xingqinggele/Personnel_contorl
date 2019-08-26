package com.zhhl.personnel_contorl.di.component;


import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.di.module.PetitionModule;
import com.zhhl.personnel_contorl.mvp.view.activities.PetitionActivity;

import dagger.Component;

/**
 * Created by miao on 2019/2/28.
 */

@ActivityScope
@Component(modules = PetitionModule.class, dependencies = AppComponent.class)
public interface PetitionComponent {
    void inject(PetitionActivity activity);
}