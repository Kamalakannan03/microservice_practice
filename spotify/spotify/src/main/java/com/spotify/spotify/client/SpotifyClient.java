package com.spotify.spotify.client;

import com.spotify.spotify.model.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "spotify", url = "https://accounts.spotify.com")
public interface SpotifyClient {

    @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResponse  getToken(@RequestHeader("Authorization") String authorization,
                    @RequestBody MultiValueMap<String, String> formParams);
}

