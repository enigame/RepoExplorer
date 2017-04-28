package com.my.demo.repoexplorer.network;

import com.my.demo.repoexplorer.model.Repo;
import com.my.demo.repoexplorer.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017-04-27.
 */

public interface GitHubRestAPI {
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("users/{username}/repos?sort=stargazers_count&direction=desc")
    Call<List<Repo>> getUserRepos(@Path("username") String username);
}
