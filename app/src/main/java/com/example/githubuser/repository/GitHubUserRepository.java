package com.example.githubuser.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.githubuser.GitHubUser;
import com.example.githubuser.api.GitHubApi;
import com.example.githubuser.api.GitHubApiProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubUserRepository {
    private GitHubApi mGitHubApi = GitHubApiProvider.getGitHubApi();

    public LiveData<List<GitHubUser>> getGitHubUser(){
        MutableLiveData<List<GitHubUser>> listUser =
                new MutableLiveData<>(new ArrayList<>());

        mGitHubApi.getGitHubUser().enqueue(new Callback<List<GitHubUser>>() {
            @Override
            public void onResponse(Call<List<GitHubUser>> call,
                                   Response<List<GitHubUser>> response) {
                listUser.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<GitHubUser>> call, Throwable t) {
            }
        });

        return listUser;
    }
}
