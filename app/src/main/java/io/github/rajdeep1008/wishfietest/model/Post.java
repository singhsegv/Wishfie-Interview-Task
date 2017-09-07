package io.github.rajdeep1008.wishfietest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public class Post {
    @SerializedName("id")
    private String id;

    @SerializedName("thumbnail_image")
    private String thumbnailImage;

    @SerializedName("event_name")
    private String eventName;

    @SerializedName("event_timestamp")
    private int eventTimestamp;

    @SerializedName("views")
    private int views;

    @SerializedName("likes")
    private int likes;

    @SerializedName("shares")
    private int shares;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(int eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }
}
