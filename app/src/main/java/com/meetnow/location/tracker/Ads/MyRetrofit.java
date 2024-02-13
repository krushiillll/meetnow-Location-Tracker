package com.meetnow.location.tracker.Ads;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    public static String baseUrl1 = "http://52.66.147.130/";

    public static Retrofit retrofit  = new Retrofit.Builder()
            .baseUrl(baseUrl1)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getRetrofitInstance(){


    }
}
