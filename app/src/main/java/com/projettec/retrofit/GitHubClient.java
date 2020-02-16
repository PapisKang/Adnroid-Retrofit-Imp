package com.projettec.retrofit;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.converter.gson.*;




public interface GitHubClient {

    @GET("users/{username}/repos")
    Call<List<RepoList>> UserRepositories(@Path("username") String userName);

}
