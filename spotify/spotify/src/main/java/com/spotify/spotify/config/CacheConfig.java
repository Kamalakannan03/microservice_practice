package com.spotify.spotify.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine; // from Caffeine
import org.springframework.cache.caffeine.CaffeineCache; // Spring's wrapper

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCache spotifyTokenCache = new CaffeineCache("spotifyToken",
                Caffeine.newBuilder()
                        .expireAfterWrite(3600, TimeUnit.SECONDS) // 1 hour token expiry
                        .maximumSize(1) // only one token needed
                        .build());

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(List.of(spotifyTokenCache));
        return manager;
    }
}
