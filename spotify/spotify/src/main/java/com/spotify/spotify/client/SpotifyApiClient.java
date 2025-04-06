package com.spotify.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotifyapiclient", url = "https://api.spotify.com/v1")
public interface SpotifyApiClient {

    @GetMapping("/artists/{artistId}")
    Object getData(@RequestHeader("Authorization") String bearerToken, @PathVariable String artistId);

    @GetMapping("/artists")
    Object getServeralArtistData(@RequestHeader("Authorization") String bearerToken, @RequestParam String ids);
}

