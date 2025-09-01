package com.example.jpopkoi_server.infrastructure.melon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MelonService {
    private final MelonClient melonClient;

    public String execute(String songName) {
        return melonClient.searchUrl(songName);
    }
}

