package com.orchestration.orchestration.service;

import com.orchestration.orchestration.client.SpotifyClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestrationService {
    private final SpotifyClient spotifyClient;

    public OrchestrationService(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }

    public Object getArtist(String id){
        return spotifyClient.getArtist(id);
    }
}
