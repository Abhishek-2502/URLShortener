package com.url.shortner.controllers;

import com.url.shortner.models.UrlMapping;
import com.url.shortner.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @Autowired
    private UrlMappingService urlMappingService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        UrlMapping urlMapping = urlMappingService.getOriginalUrl(shortUrl);
        if (urlMapping != null) {
            HttpHeaders httpHeaders = new HttpHeaders();

            // Ensure no double slash
            String originalUrl = urlMapping.getOriginalUrl();
            if (originalUrl.startsWith("/")) {
                originalUrl = originalUrl.substring(1);
            }

            httpHeaders.add("Location", originalUrl);
            return ResponseEntity.status(302).headers(httpHeaders).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
