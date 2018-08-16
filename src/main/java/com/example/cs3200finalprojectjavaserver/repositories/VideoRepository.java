package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query("SELECT video FROM Video video WHERE video.youtubeID=:youtubeID")
    Video findVideoByYoutubeId(String youtubeID);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=0 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgOverallById(int id);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=1 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgHumorById(int id);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=2 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgInformativenessById(int id);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=3 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgProductionById(int id);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=4 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgCutenessById(int id);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=5 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgSadnessById(int id);

    @Query(value = "SELECT * FROM Video WHERE title LIKE %:keyword% OR channel_title LIKE %:keyword%", nativeQuery = true)
    List<Video> findAllVideosWithKeyword(@Param("keyword") String keyword);

}