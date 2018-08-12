package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Rating;
import com.example.cs3200finalprojectjavaserver.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/api/rating")
    public List<Rating> findAllRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    @GetMapping("/api/rating/{id}")
    public Rating findRatingById(@PathVariable("id") String id) {
        int ratingId = Integer.parseInt(id);
        return ratingRepository.findById(ratingId).get();
    }

    @PostMapping("/api/rating")
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping("/api/rating/{ratingId}")
    public Rating updateRating(@PathVariable("id") String id, @RequestBody Rating rating) {
        Rating oldRating = ratingRepository.findById(Integer.parseInt(id)).get();
        oldRating.updateRating(rating);
        return ratingRepository.save(oldRating);
    }

    @DeleteMapping("/api/rating/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId) {
        ratingRepository.deleteById(Integer.parseInt(ratingId));
    }

}
