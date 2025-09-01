package com.example.jpopkoi_server.infrastructure.youtube;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YoutubeService {
    private final YouTubeClient youTubeClient;

    public String execute(String songName, String artistName) {
        String query = songName + " " + artistName + " official MV";
        return youTubeClient.searchMV(query);
    }
}
