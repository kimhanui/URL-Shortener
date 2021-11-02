package com.smile.urlshortener.web;

import com.smile.urlshortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping("/shorten")
    public String shorten(@ModelAttribute String url) {
        log.info("original: " + url);
        String res = urlShortenerService.create(url);
        log.info("fake: " + res);

        return res;
    }
}
