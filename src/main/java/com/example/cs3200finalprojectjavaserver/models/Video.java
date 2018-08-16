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
    private int viewCount;
    private int likes;
    private int dislikes;
    private double avgOverall;
    private double avgHumor;
    private double avgInformativeness;
    private double avgProduction;
    private double avgCuteness;
    private double avgSadness;
    @ManyToOne()
    private User uploader;
    @OneToMany()
    @JoinColumn(name="video_id", referencedColumnName="id")
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public double getAvgOverall() {
        return avgOverall;
    }

    public void setAvgOverall(double avgOverall) {
        this.avgOverall = avgOverall;
    }

    public double getAvgHumor() {
        return avgHumor;
    }

    public void setAvgHumor(double avgHumor) {
        this.avgHumor = avgHumor;
    }

    public double getAvgInformativeness() {
        return avgInformativeness;
    }

    public void setAvgInformativeness(double avgInformativeness) {
        this.avgInformativeness = avgInformativeness;
    }

    public double getAvgProduction() {
        return avgProduction;
    }

    public void setAvgProduction(double avgProduction) {
        this.avgProduction = avgProduction;
    }

    public double getAvgCuteness() {
        return avgCuteness;
    }

    public void setAvgCuteness(double avgCuteness) {
        this.avgCuteness = avgCuteness;
    }

    public double getAvgSadness() {
        return avgSadness;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public void setAvgSadness(double avgSadness) {
        this.avgSadness = avgSadness;
    }

    public void updateVideo(Video video) {
        this.likes = video.likes;
        this.dislikes = video.dislikes;
        this.viewCount = video.viewCount;
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
