package com.sameer.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Myinterface {
    @GET("dayone/country/{input}")
    Call<String> getValue(@Path("input") String i);


}
