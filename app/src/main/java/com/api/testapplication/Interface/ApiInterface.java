package com.api.testapplication.Interface;

import com.api.testapplication.Model.Result;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    String BASE_URL = "https://reqres.in/api/";
    @GET("users")
    Call<Result> getDisplayData(@QueryMap Map<String, String> params);
}
