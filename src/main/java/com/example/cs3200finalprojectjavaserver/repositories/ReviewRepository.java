package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Review;
import com.example.cs3200finalprojectjavaserver.models.User;
import com.example.cs3200finalprojectjavaserver.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    //TODO idk if this will actually work
//    @Query("SELECT review FROM Review review WHERE review.user=:user.id AND review.video=:video.id")
//    User findReviewByVideoAndUser(User user, Video video);

}