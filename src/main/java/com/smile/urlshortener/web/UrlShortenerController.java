package com.smile.urlshortener.web;

import com.smile.urlshortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping("/shorten")
    public String shorten(@RequestParam String url) throws Exception{
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

    @GetMapping("/{shortenPath}")
    public void redirect(HttpServletRequest request, HttpServletResponse response,  @PathVariable("shortenPath") String shortenPath) throws IOException {
        log.info("request url: " + request.getRequestURL()+" shortenPath: " + shortenPath);
        String res = urlShortenerService.findOriginalURL(request.getRequestURL().toString());
        response.sendRedirect(res);
        return;
    }
}
