package com.example.demoapplication.data.repository.remote.api;


import com.example.demoapplication.data.repository.remote.api.retrofit.CatApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class RetrofitClient {

    private static final String TAG = "RetrofitClient";
    private static final String VERSION_CODE_V1 = "/v1/";
    private static final String BASE_URL = "https://api.thecatapi.com";
    private static RetrofitClient instance = null;
    public static CatApiService networkService;



    private static Retrofit retrofit;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL + VERSION_CODE_V1)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            networkService = retrofit.create(CatApiService.class);

        }
        return retrofit;
    }

    public static CatApiService getNetWorkService(){
        return networkService;
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

}
