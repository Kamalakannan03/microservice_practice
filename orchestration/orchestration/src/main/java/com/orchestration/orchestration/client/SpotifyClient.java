package com.orchestration.orchestration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "myspotify", url = "http://localhost:8080")
public interface SpotifyClient {

    @GetMapping("/api/v1/getArtist/{id}")
    Object getArtist(@PathVariable("id") String id);
}
