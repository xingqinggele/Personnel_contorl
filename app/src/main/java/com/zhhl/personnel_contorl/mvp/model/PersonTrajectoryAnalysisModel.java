package com.zhhl.personnel_contorl.mvp.model;

import com.google.gson.Gson;
import com.zhhl.personnel_contorl.common.BaseModel;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.ChangQuDiData;
import com.zhhl.personnel_contorl.data.GxclData;
import com.zhhl.personnel_contorl.data.GxrData2;
import com.zhhl.personnel_contorl.data.Trajectory;
import com.zhhl.personnel_contorl.mvp.contacts.PersonTrajectoryAnalysisContract;
import com.zhhl.personnel_contorl.net.ITrajectory;


import io.reactivex.Observable;

public class PersonTrajectoryAnalysisModel extends BaseModel implements PersonTrajectoryAnalysisContract.Model {

    private final ITrajectory iTrajectory;

    public PersonTrajectoryAnalysisModel(OriginApp application, Gson gson, ITrajectory iMd) {
        super(application, gson);
        this.iTrajectory = iMd;
    }


    @Override
    public Observable<Trajectory> selfTrajectory(String idNumber, String start, String end, String value) {
        return iTrajectory.selfTrajectory(idNumber, start, end, value);
    }

    @Override
    public Observable<ChangQuDiData> frequented(String idNumber, String start, String end, String value) {
        return iTrajectory.frequented(idNumber, start, end, value);
    }

    @Override
    public Observable<GxclData> trajectoryGxcl(String idNumber) {
        return iTrajectory.trajectoryGxcl(idNumber);
    }

    @Override
    public Observable<GxrData2> trajectoryGxr(String idNumber, String start, String end) {
        return iTrajectory.trajectoryGxr(idNumber, start, end);
    }
}

