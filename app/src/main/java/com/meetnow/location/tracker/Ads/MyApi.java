package com.meetnow.location.tracker.Ads;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MyApi {

    @Headers("Authorization:admin")
    @GET("/dashboard/api/ads/11/")
    Call<Datum> getResponse();
}
