package com.example.jpopkoi_server.infrastructure.spotify;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpotifyService {
    private final SpotifyClient spotifyClient;

    public List<Map<String, Object>> execute(String keyword, int limit) {
        return spotifyClient.search(keyword, limit);
    }
}
