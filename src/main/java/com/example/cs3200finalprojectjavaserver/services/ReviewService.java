package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Review;
import com.example.cs3200finalprojectjavaserver.models.Video;
import com.example.cs3200finalprojectjavaserver.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/api/review")
    public List<Review> findAllVideos() {
        return (List<Review>) reviewRepository.findAll();
    }

    @GetMapping("/api/review/{id}")
    public Review findReviewById(@PathVariable("id") String id) {
        int reviewId = Integer.parseInt(id);
        return reviewRepository.findById(reviewId).get();
    }

    @PostMapping("/api/review")
    public Review createVideo(@RequestBody Review review) {
       // if (reviewRepository.findReviewByVideoAndUser(review.getUser(), review.getVideo()) == null) {
            reviewRepository.save(review);
            return review;
        //}
        //return null;
    }
}
