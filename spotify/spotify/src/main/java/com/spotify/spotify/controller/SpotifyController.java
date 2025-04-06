package com.spotify.spotify.controller;

import com.spotify.spotify.service.SpotifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SpotifyController {

    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }
    @GetMapping("/getArtist/{artistId}")
    public Object fetchData(@PathVariable String artistId){
        return spotifyService.fetchArtistData(artistId);
    }

    @GetMapping("/getSeveralArtist/{ids}")
    public Object fetchSeveralData(@PathVariable String ids){
        return spotifyService.fetchSeveralArtistData(ids);
    }
}
