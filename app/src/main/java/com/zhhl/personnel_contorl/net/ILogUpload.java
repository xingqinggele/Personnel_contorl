package com.zhhl.personnel_contorl.net;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ILogUpload {
    @POST(Api.log)
    @FormUrlEncoded
    Observable<Object> upload(@Field("policeId") String policeId,
                              @Field("sn") String sn,
                              @Field("cardNo") String cardNo,
                              @Field("source") String source,
                              @Field("logType") String logType,
                              @Field("params") String params,
                              @Field("uri") String uri,
                              @Field("url") String url,
                              @Field("result") String result,
                              @Field("terminalIp") String terminalIp,
                              @Field("module") String module,
                              @Field("formatParam") String formatParam,
                              @Field("content") String content,
                              @Field("response") String response,
                              @Field("responseType") String responseType,
                              @Field("responseTime") String responseTime,
                              @Field("errorLog") String errorLog,
                              @Field("sourceIp") String sourceIp,
                              @Field("sourcePort") String sourcePort,
                              @Field("destIp") String destIp,
                              @Field("destPort") String destPort,
                              @Field("time") String time
    );
}
