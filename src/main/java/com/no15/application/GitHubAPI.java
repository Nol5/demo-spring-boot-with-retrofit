package com.no15.application;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubAPI {

    @GET("users/{userName}")
    Call<User> getUserWithUserName(@Path("userName") String userName);

}
