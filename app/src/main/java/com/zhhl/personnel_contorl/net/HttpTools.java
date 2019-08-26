package com.zhhl.personnel_contorl.net;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by miao on 2018/6/21.
 */
public class HttpTools {
    private static OkHttpClient client;
    private static final HashMap<Class<?>, Object> interfaces = new HashMap<>();

    private static OkHttpClient okHttpClient() {
        if (client == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
            builder.connectTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS);
            client = builder.build();
        }
        return client;
    }

    public static <T> T build(Class<T> classes) {
        T target = (T) interfaces.get(classes);
        if (target == null) {
            target = new Retrofit.Builder()
                    .baseUrl(Api.__BASED__.SERVER_IP)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient())
                    .build()
                    .create(classes);
            interfaces.put(classes, target);
        }
        return target;
    }

    public static Login buildLogin() {
        Login target = (Login) interfaces.get(Login.class);
        if (target == null) {
            target = new Retrofit.Builder()
                    .baseUrl(Api.__BASED__.__Login_Url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient())
                    .build()
                    .create(Login.class);
            interfaces.put(Login.class, target);
        }
        return target;
    }


    public static<T> T  build(Class<?extends  T>  iInterface, String s) {
        return new Retrofit.Builder()
                .baseUrl(s)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build()
                .create(iInterface);
    }
}
