package com.example.githubuser.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubuser.GitHubUser;
import com.example.githubuser.R;
import com.example.githubuser.api.GitHubApiProvider;
import com.example.githubuser.databinding.GithubUserItemBinding;

import java.util.ArrayList;
import java.util.List;

public class GitHubUserAdapter
        extends RecyclerView.Adapter<GitHubUserAdapter.GitHubUserViewHolder> {
    private List<GitHubUser> mData = new ArrayList<>();
    private Context mContext;

    public GitHubUserAdapter(Context context, List<GitHubUser> data){
        mContext = context;
        mData = data;
    }

    public void setData(List<GitHubUser> data){
        mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GitHubUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GithubUserItemBinding binding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.github_user_item, parent, false);
        return new GitHubUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubUserViewHolder holder, int position) {
        holder.bindView(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class GitHubUserViewHolder extends RecyclerView.ViewHolder{
        GithubUserItemBinding binding;

        public GitHubUserViewHolder(GithubUserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(GitHubUser user){
            binding.setGitUser(user);
        }
    }
}
