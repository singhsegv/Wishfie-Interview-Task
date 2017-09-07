package io.github.rajdeep1008.wishfietest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

// Renamed it so that it doesn't clash with Response class of retrofit
public class ResponseModel<T> {

    @SerializedName("posts")
    private ArrayList<T> posts;

    @SerializedName("page")
    private int page;

    public ArrayList<T> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<T> posts) {
        this.posts = posts;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
