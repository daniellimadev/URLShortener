package com.github.daniellimadev.URLShortener.repository;

import com.github.daniellimadev.URLShortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByUrlShortened(String urlShortened);
}
