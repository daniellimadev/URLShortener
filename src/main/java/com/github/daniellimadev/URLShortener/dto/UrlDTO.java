package com.github.daniellimadev.URLShortener.dto;

import java.time.LocalDateTime;

public record UrlDTO(
        Long id,
        String fullUrl,
        String urlShortened,
        LocalDateTime urlCreatedIn
) {
}
