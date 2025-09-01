package com.example.jpopkoi_server.infrastructure.spotify;

import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SpotifyClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${spotify.base-url}")
    private String baseUrl;

    @Value("${spotify.token}")
    private String token;

    public List<Map<String, Object>> search(String keyword, int limit) {
        String url = String.format("%s/search?q=%s&type=track&limit=%d", baseUrl, keyword, limit);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        Map<String, Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class).getBody();
        Map tracks = (Map) response.get("tracks");
        return (List<Map<String, Object>>) tracks.get("items");
    }
}
