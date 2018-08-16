package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query(value = "SELECT review.review_text FROM User user JOIN Video video ON user.id=video.uploader_id JOIN Review review ON video.id=review.video_id WHERE user.id=:user AND video.id=:video", nativeQuery = true)
    List<Review> findAllReviewsForVideoForUser(int user, int video);
}
