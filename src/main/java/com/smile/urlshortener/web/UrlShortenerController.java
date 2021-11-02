package com.smile.urlshortener.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class UrlShortenerController {

    @GetMapping("/shorten")
    public String shorten(@ModelAttribute PushUrlDto pushUrl) {
        log.info(pushUrl.getUrl());
        return "shorten-url";
    }
}
