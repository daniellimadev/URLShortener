package com.github.daniellimadev.URLShortener.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullUrl;
    private String urlShortened;

    private LocalDateTime urlCreatedIn;

    public Url(Long id, String fullUrl, String urlShortened, LocalDateTime urlCreatedIn) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.urlShortened = urlShortened;
        this.urlCreatedIn = urlCreatedIn;
    }

    public Url() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getUrlShortened() {
        return urlShortened;
    }

    public void setUrlShortened(String urlShortened) {
        this.urlShortened = urlShortened;
    }

    public LocalDateTime getUrlCreatedIn() {
        return urlCreatedIn;
    }

    public void setUrlCreatedIn(LocalDateTime urlCreatedIn) {
        this.urlCreatedIn = urlCreatedIn;
    }
}
