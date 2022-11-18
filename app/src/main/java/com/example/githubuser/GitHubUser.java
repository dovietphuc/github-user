package com.example.githubuser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubUser {

    @SerializedName("login")
    @Expose
    private String loginName;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public GitHubUser(String loginName, String id, String avatarUrl) {
        this.loginName = loginName;
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "loginName='" + loginName + '\'' +
                ", id='" + id + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
