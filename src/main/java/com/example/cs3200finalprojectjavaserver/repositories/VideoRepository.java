package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query("SELECT video FROM Video video WHERE video.youtubeID=:youtubeID")
    Video findVideoByYoutubeId(String youtubeID);

    @Query(value = "SELECT avg(rating_value) FROM Video video JOIN Review review ON video.id=review.video_id JOIN Rating rating ON review.id=rating.review_id WHERE rating.rating_type=1 AND video.id=:id GROUP BY video.id", nativeQuery = true)
    double getAvgHumorById(int id);

    double getAvgInformativeById(int id);

    double getAvgProductionById(int id);

    double getAvgOverallById(int id);

    @Query(value = "SELECT * FROM Video WHERE title LIKE %:keyword% OR channel_title LIKE %:keyword%", nativeQuery = true)
    List<Video> findAllVideosWithKeyword(@Param("keyword") String keyword);

}