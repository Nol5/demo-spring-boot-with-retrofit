package com.no15.application;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login") String login;
    @SerializedName("name") String name;
    @SerializedName("blog") String blog;
    @SerializedName("bio") String bio;
    @SerializedName("avatar_url") String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
