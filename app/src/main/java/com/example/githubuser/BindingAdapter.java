package com.example.githubuser;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubuser.ui.GitHubUserAdapter;

import java.util.List;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter({"loadUrl"})
    public static void loadImage(ImageView view, String url){
        Glide.with(view.getContext())
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_baseline_error_24)
                .circleCrop()
                .into(view);
    }

    @androidx.databinding.BindingAdapter({"loadUser"})
    public static void loadUser(RecyclerView recyclerView, List<GitHubUser> gitHubUsers){
        if(recyclerView.getAdapter() instanceof GitHubUserAdapter){
            GitHubUserAdapter adapter = (GitHubUserAdapter) recyclerView.getAdapter();
            adapter.setData(gitHubUsers);
        }
    }
}
