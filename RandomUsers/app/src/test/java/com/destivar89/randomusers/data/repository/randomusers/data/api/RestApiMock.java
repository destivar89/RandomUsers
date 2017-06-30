package com.destivar89.randomusers.data.repository.randomusers.data.api;


import com.destivar89.randomusers.BuildConfig;
import com.destivar89.randomusers.data.api.ApiClientGenerator;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiMock implements ApiClientGenerator {

    private Retrofit retrofit;


    public RestApiMock(HttpUrl url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public <T> T generatedApi(Class<T> service) {
        return retrofit.create(service);
    }

}
