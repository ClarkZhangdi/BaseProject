package com.clark.baseproject.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created By Clark
 * Description :
 *
 * @date 2019/5/21.
 */
public interface GitHubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


    @GET("users/{user}/repos")
    Call<Object> listReposOBJ(@Path("user") String user);

}
