package com.example.cs3200finalprojectjavaserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

enum RatingType {
    OVERALL,
    HUMOR,
    AGE,
    INFORMATIVE,
    PRODUCTION
}

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private RatingType ratingType;
    private int ratingValue;
    @ManyToOne
    @JsonIgnore
    private Review review;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
