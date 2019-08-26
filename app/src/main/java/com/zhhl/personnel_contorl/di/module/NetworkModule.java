package com.zhhl.personnel_contorl.di.module;


import com.zhhl.personnel_contorl.BuildConfig;
import com.zhhl.personnel_contorl.net.Api;
import com.zhhl.personnel_contorl.net.ILogUpload;
import com.zhhl.personnel_contorl.net.IModelInformation;
import com.zhhl.personnel_contorl.net.ITrajectory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miao on 2018/6/21.
 */

@Module
public class NetworkModule {

    private static Retrofit retrofitCreator1(OkHttpClient client) {
        return retrofitCreator1(client, Api.__BASED__.SERVER_IP);
    }

    private static Retrofit retrofitCreator1(OkHttpClient client, String basedUrl) {
        return new Retrofit.Builder()
                .baseUrl(basedUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

//    private static Retrofit retrofitCreator2(OkHttpClient client) {
//        return new Retrofit.Builder()
//                .baseUrl(Api.__BASED__.__BASED_Url2)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();
//    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
    }

//    @Singleton
//    @Provides
//    ITrajectoryAnalysis provideICountInterface(OkHttpClient client) {
//        return retrofitCreator1(client).create(ITrajectoryAnalysis.class);
//    }

    @Singleton
    @Provides
    ITrajectory provideTrajectoryInterface(OkHttpClient client) {
        return retrofitCreator1(client).create(ITrajectory.class);
    }

    @Singleton
    @Provides
    IModelInformation provideModelInterface(OkHttpClient client) {
        return retrofitCreator1(client).create(IModelInformation.class);
    }

    @Singleton
    @Provides
    ILogUpload provideLogUploadInterface(OkHttpClient client) {
        return retrofitCreator1(client,"http://192.168.20.228:7122/").create(ILogUpload.class);
    }
}
