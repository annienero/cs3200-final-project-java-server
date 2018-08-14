package com.example.cs3200finalprojectjavaserver.services;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge=3600, allowCredentials = "true")
public class ApiKeyService {

    public static String youtubeApiKey = "AIzaSyA98JIs8z8_re421k9X386ggPr5Ok5_M1Q";

    @GetMapping("/api/youtubeApi")
    public String getYoutubeApiKey() {
        return youtubeApiKey;
    }

}
