package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Video;
import com.example.cs3200finalprojectjavaserver.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @GetMapping("/api/video")
    public List<Video> findAllVideos() {
        return (List<Video>) videoRepository.findAll();
    }

    @GetMapping("/api/video/{id}")
    public Video findVideoById(@PathVariable("id") String id) {
        int videoId = Integer.parseInt(id);
        return videoRepository.findById(videoId).get();
    }

    @PostMapping("/api/video")
    public Video createVideo(@RequestBody Video video) {
        if (videoRepository.findVideoByUrl(video.getUrl()) == null) {
            videoRepository.save(video);
            return video;
        }
        return null;
    }

}
