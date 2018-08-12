package com.example.cs3200finalprojectjavaserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String url;
    private String title;
    @OneToMany(mappedBy="video")
    private List<Review> reviews;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void updateVideo(Video video) {
        if (video.title != null) {
            this.title = video.title;
        }
        if (video.url != null) {
            this.url = video.url;
        }
    }
}
