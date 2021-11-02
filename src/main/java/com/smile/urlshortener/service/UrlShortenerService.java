package com.smile.urlshortener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UrlShortenerService {

    private final String NEW_URL_DOMAIN = "hanui.com";

    /**
     * protocol, domain, path
     */
    public String create(String url) {
        String protocol = url.split(":")[0];
        log.info(protocol);
        String path = URLUtil.getPath(url);
        log.info(path);
        String shortenPath = URLUtil.getShortenPath(path);

        StringBuffer sb = new StringBuffer();
        sb.append(protocol);
        sb.append(NEW_URL_DOMAIN);
        sb.append(shortenPath);
        return sb.toString();
    }


}
