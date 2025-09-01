package com.example.jpopkoi_server.infrastructure.openai;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenaiService {
    private final OpenaiClient openaiClient;

    public String execute(String query) {
        return openaiClient.openai(query);
    }

}
