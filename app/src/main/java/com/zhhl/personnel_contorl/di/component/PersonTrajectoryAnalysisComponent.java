package com.zhhl.personnel_contorl.di.component;



import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.di.module.PersonTrajectoryAnalysisModule;
import com.zhhl.personnel_contorl.mvp.view.activities.PersonTrajectoryAnalysisActivity;

import dagger.Component;


@ActivityScope
@Component(modules = PersonTrajectoryAnalysisModule.class, dependencies = AppComponent.class)
public interface PersonTrajectoryAnalysisComponent {
    void inject(PersonTrajectoryAnalysisActivity activity);
}