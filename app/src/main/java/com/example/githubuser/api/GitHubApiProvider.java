package com.example.githubuser.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubApiProvider {
    public static String BASE_URL = "https://api.github.com";
    private static GitHubApi mGitHubApi;
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit(){
        if(mRetrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            mRetrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static GitHubApi getGitHubApi(){
        if(mGitHubApi == null){
            Retrofit retrofit = getRetrofit();
            mGitHubApi = retrofit.create(GitHubApi.class);
        }
        return mGitHubApi;
    }
}
