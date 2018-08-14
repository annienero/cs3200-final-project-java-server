package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.Video;
import com.example.cs3200finalprojectjavaserver.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge=3600, allowCredentials = "true")
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
        if (videoRepository.findVideoByYoutubeId(video.getYoutubeID()) == null) {
            videoRepository.save(video);
            return video;
        }
        return null;
    }

    @PutMapping("/api/video/{videoId}")
    public Video updateVideo(@PathVariable("id") String id, @RequestBody Video video) {
        Video oldVideo = videoRepository.findById(Integer.parseInt(id)).get();
        oldVideo.updateVideo(video);
        return videoRepository.save(oldVideo);
    }

    @DeleteMapping("/api/video/{videoId}")
    public void deleteVideo(@PathVariable("videoId") String videoId) {
        videoRepository.deleteById(Integer.parseInt(videoId));
    }

}
