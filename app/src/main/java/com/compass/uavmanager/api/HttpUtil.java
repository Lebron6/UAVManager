package com.compass.uavmanager.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {
    /**
     * 初始化okhttpclient.
     * @return okhttpClient
     */
    public OkHttpClient okhttpclient() {
//        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger(getClass().getSimpleName()));
//        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();
        return mOkHttpClient;
    }

    public UavApi createRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(okhttpclient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UavApi vamApi = retrofit.create(UavApi.class);
        return vamApi;
    }
    public UavApi createRequest2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.ipAddress2)
                .client(okhttpclient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UavApi vamApi = retrofit.create(UavApi.class);
        return vamApi;
    }
}
