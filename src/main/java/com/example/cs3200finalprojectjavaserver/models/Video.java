package com.example.cs3200finalprojectjavaserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String youtubeID;
    private String title;
    private String channelTitle;
    @OneToMany(mappedBy="video")
    private List<Review> reviews;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYoutubeID() {
        return youtubeID;
    }

    public void setYoutubeID(String youtubeID) {
        this.youtubeID = youtubeID;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public void updateVideo(Video video) {
        if (video.title != null) {
            this.title = video.title;
        }
        if (video.youtubeID != null) {
            this.youtubeID = video.youtubeID;
        }
        if (video.channelTitle != null) {
            this.channelTitle = video.channelTitle;
        }
    }
}
