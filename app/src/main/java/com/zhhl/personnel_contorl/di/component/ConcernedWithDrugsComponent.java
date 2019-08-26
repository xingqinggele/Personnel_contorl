package com.zhhl.personnel_contorl.di.component;

import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.di.module.ConcernedWithDrugsModule;
import com.zhhl.personnel_contorl.mvp.view.activities.ConcernedWithDrugsActivity;

import dagger.Component;

/**
 * Created by miao on 2019/4/1.
 */

@ActivityScope
@Component(modules = ConcernedWithDrugsModule.class, dependencies = AppComponent.class)
public interface ConcernedWithDrugsComponent {
    void inject(ConcernedWithDrugsActivity activity);
}