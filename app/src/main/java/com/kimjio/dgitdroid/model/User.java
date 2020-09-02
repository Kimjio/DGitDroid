package com.kimjio.dgitdroid.model;

import java.util.Date;

public class User {
    private String name;
    private String userID;
    private String userImage;
    private String bio;
    private int totalContributions;
    private int weekContributions;
    private Date createdAt;

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getBio() {
        return bio;
    }

    public int getTotalContributions() {
        return totalContributions;
    }

    public int getWeekContributions() {
        return weekContributions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
