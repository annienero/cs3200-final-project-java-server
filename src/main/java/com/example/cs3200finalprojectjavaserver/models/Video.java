package com.example.cs3200finalprojectjavaserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String url;
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
}
