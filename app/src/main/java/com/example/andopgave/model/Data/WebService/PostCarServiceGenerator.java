package com.example.andopgave.model.Data.WebService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;

//Specify BaseUrl for the Endpoint and the conveter your are using
public class PostCarServiceGenerator {
    private static PostCarAPI carAPI;
    @Headers({"X-AUTH-TOKEN: " + "3enipvlz3yez9qvfnfrzzsuvt4sia34q"})

    public static PostCarAPI getCarAPI() {

        OkHttpClient.Builder ok = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        ok.addInterceptor(httpLoggingInterceptor);
        if (carAPI == null) {
            carAPI = new Retrofit.Builder()
                    .baseUrl("https://v1.motorapi.dk")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PostCarAPI.class);
        }
        return carAPI;
    }



}
