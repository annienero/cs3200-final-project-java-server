package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query("SELECT video FROM Video video WHERE video.youtubeID=:youtubeID")
    Video findVideoByYoutubeId(String youtubeID);
//
////    select Video.id, avg(Rating.value)
////    from Video join Review using(Video.id) join Rating using(Review.id)
////    where Rating.RatingType like 'HUMOR'
////    group by Video.id
    //@Query("SELECT avg(value) FROM Rating group by id")
    double getAvgHumorById(int id);

    double getAvgInformativeById(int id);

    double getAvgProductionById(int id);

    double getAvgOverallById(int id);

    @Query(value = "SELECT * FROM Video WHERE title like %:keyword% or channel_title like %:keyword%", nativeQuery = true)
    List<Video> findAllVideosWithKeyword(@Param("keyword") String keyword);

}