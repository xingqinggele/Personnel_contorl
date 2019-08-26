package com.zhhl.personnel_contorl.net;

import com.zhhl.personnel_contorl.data.Cunguanguiji;
import com.zhhl.personnel_contorl.data.Cunguanrenyuan;
import com.zhhl.personnel_contorl.data.Cunguanzhixi;
import com.zhhl.personnel_contorl.data.PushInfo;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by miao on 2018/11/26.
 */
public interface IModelInformation {

    @Deprecated
    @POST("/jeesite/cunguan/mingdan")
    Observable<Cunguanrenyuan> cunguanmingdan();

    @Deprecated
    @POST("/jeesite/cunguan/zhixi")
    @FormUrlEncoded
    Observable<Cunguanzhixi> cunguanzhixi(@Field("sfzh") String sfzh);

    @Deprecated
    @POST("/jeesite/cunguan/guiji")
    @FormUrlEncoded
    Observable<Cunguanguiji> cunguanguiji(@Field("sfzh") String sfzh);

    @POST(Api.exceptionAtLarge)
    Observable<PushInfo> exceptionAtLarge();

    @POST(Api.exceptionPetition)
    Observable<PushInfo> exceptionPetition();

    @POST("/jeesite/jinghao/yanzheng")
    @FormUrlEncoded
    Observable<Boolean> checkPermission(@Field("jinghao") String jinghao, @Field("dizhi") String dizhi);

    @POST(Api.exceptionConcernedWithDrugs)
    Observable<PushInfo> exceptionConcernedWithDrugs();


}
