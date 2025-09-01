package com.example.jpopkoi_server.infrastructure.youtube;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class YouTubeClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${youtube.base-url}")
    private String baseUrl;

    @Value("${youtube.token}")
    private String apiKey;

    public String searchMV(String query) {
        String url = String.format(
                "%s/search?part=snippet&type=video&q=%s&maxResults=1&key=%s",
                baseUrl, query, apiKey
        );

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response == null || !response.containsKey("items")) return null;

        List<Map<String, Object>> items = (List<Map<String, Object>>) response.get("items");
        if (items.isEmpty()) return null;

        Map id = (Map) items.get(0).get("id");
        return "https://www.youtube.com/watch?v=" + id.get("videoId");
    }
}
