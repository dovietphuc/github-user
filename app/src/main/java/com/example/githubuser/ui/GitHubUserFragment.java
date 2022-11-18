package com.example.githubuser.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubuser.GitHubUser;
import com.example.githubuser.R;
import com.example.githubuser.databinding.FragmentGitHubUserBinding;

import java.util.ArrayList;
import java.util.List;

public class GitHubUserFragment extends Fragment {

    GitHubUserViewModel mGitHubUserViewModel;

    FragmentGitHubUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_git_hub_user, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGitHubUserViewModel = new ViewModelProvider(this)
                .get(GitHubUserViewModel.class);

        GitHubUserAdapter adapter =
                new GitHubUserAdapter(requireContext(), new ArrayList<>());
        binding.rcvGitHubUser.setAdapter(adapter);
        binding.rcvGitHubUser.setLayoutManager(new LinearLayoutManager(requireContext()));
        mGitHubUserViewModel.getGitHubUser().observe(getViewLifecycleOwner(), new Observer<List<GitHubUser>>() {
            @Override
            public void onChanged(List<GitHubUser> gitHubUsers) {
                binding.setListUser(gitHubUsers);
            }
        });
    }
}