package com.example.githubuser.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubuser.GitHubUser;
import com.example.githubuser.repository.GitHubUserRepository;

import java.util.List;

public class GitHubUserViewModel extends ViewModel {
    private GitHubUserRepository mGitHubUserRepository;

    public GitHubUserViewModel(){
        mGitHubUserRepository = new GitHubUserRepository();
    }

    public LiveData<List<GitHubUser>> getGitHubUser(){
        return mGitHubUserRepository.getGitHubUser();
    }
}
