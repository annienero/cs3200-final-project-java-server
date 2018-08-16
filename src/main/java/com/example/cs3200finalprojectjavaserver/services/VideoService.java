package com.example.cs3200finalprojectjavaserver.services;

import com.example.cs3200finalprojectjavaserver.models.User;
import com.example.cs3200finalprojectjavaserver.models.Video;
import com.example.cs3200finalprojectjavaserver.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.example.cs3200finalprojectjavaserver.services.UserService.USER;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @GetMapping("/api/video")
    public List<Video> findAllVideos() {
        List<Video> videos = (List<Video>) videoRepository.findAll();
        for (Video video : videos) {
            try { video.setAvgOverall(videoRepository.getAvgOverallById(video.getId())); } catch (Exception e) {}
            try { video.setAvgHumor(videoRepository.getAvgHumorById(video.getId())); } catch (Exception e) {}
            try { video.setAvgInformativeness(videoRepository.getAvgInformativenessById(video.getId())); } catch (Exception e) {}
            try { video.setAvgProduction(videoRepository.getAvgProductionById(video.getId())); } catch (Exception e) {}
            try { video.setAvgCuteness(videoRepository.getAvgCutenessById(video.getId())); } catch (Exception e) {}
            try { video.setAvgSadness(videoRepository.getAvgSadnessById(video.getId())); } catch (Exception e) {}
            videoRepository.save(video);
        }
        return videos;
    }

    @GetMapping("/api/video/search/{keyword}")
    public List<Video> findAllVideosWithKeyword(@PathVariable("keyword") String keyword) {
        return videoRepository.findAllVideosWithKeyword(keyword);
    }

    @GetMapping("/api/video/{id}")
    public Video findVideoById(@PathVariable("id") String id) {
        int videoId = Integer.parseInt(id);
        return videoRepository.findById(videoId).get();
    }

    @GetMapping("/api/youtube/{youtubeId}")
    public Video findVideoByYoutubeID(@PathVariable("youtubeId") String youtubeId) {
        return videoRepository.findVideoByYoutubeId(youtubeId);
    }

    @PostMapping("/api/video")
    public Video createVideo(@RequestBody Video video, HttpSession session) {
        if (videoRepository.findVideoByYoutubeId(video.getYoutubeID()) == null) {
            video.setUploader((User) session.getAttribute(USER));
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
