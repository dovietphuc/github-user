package com.example.githubuser.api;

import com.example.githubuser.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    @GET("users")
    public Call<List<GitHubUser>> getGitHubUser();

    @GET("users/{login}")
    public Call<GitHubUser> getGithubUser(@Path("login") String login);
}
