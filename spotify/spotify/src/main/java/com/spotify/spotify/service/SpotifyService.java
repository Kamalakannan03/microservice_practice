package com.spotify.spotify.service;

import com.spotify.spotify.client.SpotifyApiClient;
import com.spotify.spotify.client.SpotifyClient;
import com.spotify.spotify.model.TokenResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;

@Service
public class SpotifyService {
    private final SpotifyClient authClient;
    private final SpotifyApiClient apiClient;
    private final SpotifyTokenService spotifyTokenService;

    public SpotifyService(SpotifyClient authClient, SpotifyApiClient apiClient, SpotifyTokenService spotifyTokenService) {
        this.authClient = authClient;
        this.apiClient = apiClient;
        this.spotifyTokenService = spotifyTokenService;
    }

    //    public Object fetchData(String artistId) {
//        String clientId = "16718a10b73d43aeb2964e5a2432d212";
//        String clientSecret = "d64280d2a2cf43d8b5e139b49257bafb";
//
//        String authHeader = "Basic " + Base64.getEncoder()
//                .encodeToString((clientId + ":" + clientSecret).getBytes());
//
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("grant_type", "client_credentials");
//
//        TokenResponse tokenResponse = authClient.getToken(authHeader, formData);
//        String bearerToken = "Bearer " + tokenResponse.getAccess_token();
//
//       return apiClient.getData(bearerToken,artistId);
//    }
        public Object fetchArtistData(String artistId) {
            String token = spotifyTokenService.getAccessToken();
            String bearerToken = "Bearer " + token;
            return apiClient.getData(bearerToken,artistId);
        }
    public Object fetchSeveralArtistData(String artistId) {
        String token = spotifyTokenService.getAccessToken();
        String bearerToken = "Bearer " + token;
        return apiClient.getServeralArtistData(bearerToken,artistId);
    }
}
