package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Review;
import com.example.cs3200finalprojectjavaserver.models.User;
import com.example.cs3200finalprojectjavaserver.models.Video;
import com.example.cs3200finalprojectjavaserver.repositories.ReviewRepository;
import com.example.cs3200finalprojectjavaserver.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static com.example.cs3200finalprojectjavaserver.services.UserService.USER;

@RestController
@CrossOrigin(origins = "*", maxAge=3600, allowCredentials = "true")
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    VideoRepository videoRepository;

    @GetMapping("/api/review")
    public List<Review> findAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    @GetMapping("/api/review/{id}")
    public Review findReviewById(@PathVariable("id") String id) {
        int reviewId = Integer.parseInt(id);
        return reviewRepository.findById(reviewId).get();
    }

    @PostMapping("/api/video/{videoId}/review")
    public Review createReview(@PathVariable("videoId") String videoId, @RequestBody Review review, HttpSession session) {
        Optional<Video> data = videoRepository.findById(Integer.parseInt(videoId));
        if(data.isPresent()) {
            Video video = data.get();
            review.setVideo(video);
            review.setUser((User) session.getAttribute(USER));
            reviewRepository.save(review);
            return review;
        }
        return null;
    }

    @PutMapping("/api/review/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") String reviewId, @RequestBody Review review) {
        Review oldReview = reviewRepository.findById(Integer.parseInt(reviewId)).get();
        oldReview.updateReview(review);
        return reviewRepository.save(oldReview);
    }

    @DeleteMapping("/api/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") String reviewId) {
        reviewRepository.deleteById(Integer.parseInt(reviewId));
    }

//    @GetMapping("/api/user/video/{videoId}/review")
//    public List<Review> findAllReviewsForVideoForUser(@PathVariable("videoId") String videoId, @RequestBody Review review, HttpSession session) {
//        Optional<Video> data = videoRepository.findById(Integer.parseInt(videoId));
//        if(data.isPresent()) {
//            Video video = data.get();
//            User user = (User) session.getAttribute(USER);
//            return reviewRepository.findAllReviewsForVideoForUser(user.getId(), video.getId());
//        }
//        return null;
//    }

    @GetMapping("/api/video/{videoId}/review")
    public List<Review> findAllReviewsForVideo(@PathVariable("videoId") String videoId) {
        Optional<Video> data = videoRepository.findById(Integer.parseInt(videoId));
        if(data.isPresent()) {
            Video video = data.get();
            return video.getReviews();
        }
        return null;
    }
}
