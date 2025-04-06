package com.spotify.spotify.service;

import com.spotify.spotify.client.SpotifyClient;
import com.spotify.spotify.model.TokenResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;

@Service
public class SpotifyTokenService {

    private final SpotifyClient authClient;

    public SpotifyTokenService(SpotifyClient authClient) {
        this.authClient = authClient;
    }

    private final String clientId = "16718a10b73d43aeb2964e5a2432d212";
    private final String clientSecret = "d64280d2a2cf43d8b5e139b49257bafb";

    @Cacheable(value = "spotifyToken")
    public String getAccessToken() {
        System.out.println("Fetching new token from Spotify...");

        String authHeader = "Basic " + Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes());

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");

        TokenResponse tokenResponse = authClient.getToken(authHeader, formData);
        return tokenResponse.getAccess_token();
    }
}
