package com.example.jpopkoi_server.infrastructure.openai;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OpenaiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${openai.api-key}")
    private String apiKey;

    public String openai(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> request = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "system", "content", "사용자 입력을 감정/분위기 태그로 변환해줘 (예: 여름, 설렘, 슬픔)"),
                        Map.of("role", "user", "content", query)
                )
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
        Map response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", entity, Map.class);

        Map choice = (Map) ((List) response.get("choices")).get(0);
        Map message = (Map) choice.get("message");
        return message.get("content").toString().trim();
    }

}
