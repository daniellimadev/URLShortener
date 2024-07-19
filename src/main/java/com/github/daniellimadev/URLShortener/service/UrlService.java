package com.github.daniellimadev.URLShortener.service;

import com.github.daniellimadev.URLShortener.model.Url;
import com.github.daniellimadev.URLShortener.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UrlService {


    private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String generateUrlRandom() {
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Url urlShorten(String urlOriginal) throws IOException {
        Url url = new Url();
        url.setFullUrl(urlOriginal);
        url.setUrlShortened(generateUrlRandom());
        url.setUrlCreatedIn(LocalDateTime.now().plusMinutes(5));
        return urlRepository.save(url);
    }

    public Url getOriginalUrl(String shortUrl) {
        Optional<Url> optionalUrl = urlRepository.findByUrlShortened(shortUrl);
        if (optionalUrl.isPresent()) {
            Url url = optionalUrl.get();
            if (url.getUrlCreatedIn().isAfter(LocalDateTime.now())) {
                return url;
            } else {
                urlRepository.delete(url);
            }
        }
        return null;
    }

}
