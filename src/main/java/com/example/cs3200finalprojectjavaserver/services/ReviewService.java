package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Review;
import com.example.cs3200finalprojectjavaserver.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge=3600, allowCredentials = "true")
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/api/review")
    public List<Review> findAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    @GetMapping("/api/review/{id}")
    public Review findReviewById(@PathVariable("id") String id) {
        int reviewId = Integer.parseInt(id);
        return reviewRepository.findById(reviewId).get();
    }

    @PostMapping("/api/review")
    public Review createReview(@RequestBody Review review) {
        //TODO
       // if (reviewRepository.findReviewByVideoAndUser(review.getUser(), review.getVideo()) == null) {
            reviewRepository.save(review);
            return review;
        //}
        //return null;
    }

    @PutMapping("/api/review/{reviewId}")
    public Review updateReview(@PathVariable("id") String id, @RequestBody Review review) {
        Review oldReview = reviewRepository.findById(Integer.parseInt(id)).get();
        oldReview.updateReview(review);
        return reviewRepository.save(oldReview);
    }

    @DeleteMapping("/api/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") String reviewId) {
        reviewRepository.deleteById(Integer.parseInt(reviewId));
    }
}
