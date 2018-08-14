package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query("SELECT video FROM Video video WHERE video.youtubeID=:youtubeID")
    Video findVideoByYoutubeId(String youtubeID);
}