package com.smile.urlshortener.web;

import com.smile.urlshortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping("/shorten")
    public String shorten(@RequestParam String url) {
        log.info("original: " + url);
        String res = urlShortenerService.create(url);
        log.info("fake: " + res);

        return res;
    }

    @GetMapping("/original")
    public String original(@RequestParam String url) throws Exception{
        log.info("short: " + url);
        String res = urlShortenerService.findOriginalURL(url);
        return res;
    }
}
