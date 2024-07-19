package com.github.daniellimadev.URLShortener.controller;

import com.github.daniellimadev.URLShortener.dto.UrlDTO;
import com.github.daniellimadev.URLShortener.model.Url;
import com.github.daniellimadev.URLShortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;


    @PostMapping("/urlShortener")
    public ResponseEntity<UrlDTO> urlShortener(@RequestBody Map<String, String> request) throws IOException {

        String urlOriginal = request.get("urlOriginal");
        Url url = urlService.urlShorten(urlOriginal);

        String generateRedirectUrl = "http://localhost:8080/r/" + url.getUrlShortened();

        UrlDTO urlShortenerResponse = new UrlDTO(
                url.getId(),
                url.getFullUrl(),
                generateRedirectUrl,
                url.getUrlCreatedIn()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(urlShortenerResponse);
    }


    @GetMapping("/r/{urlShorten}")
   public void redirectUrl(@PathVariable String urlShorten, HttpServletResponse response) throws IOException {

        Url url = urlService.getOriginalUrl(urlShorten);

        if (Objects.nonNull(url)) {
            response.sendRedirect(url.getFullUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
   }

}
