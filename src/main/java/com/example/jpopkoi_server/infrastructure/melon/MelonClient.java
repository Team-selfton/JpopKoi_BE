package com.example.jpopkoi_server.infrastructure.melon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MelonClient {
    public String searchUrl(String songName) {
        return "https://www.melon.com/search/total/index.htm?q=" + songName;
    }
}
