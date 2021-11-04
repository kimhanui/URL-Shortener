package com.smile.urlshortener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class URLUtil {

    private static final String NEW_URL_PREFIX = "http://localhost:8080/";
    private static final String BASECHAR
        = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Create short URL
     */
    public static String createShortURL(int savedId) {
        String shortURL = toShortURL(savedId);
        return NEW_URL_PREFIX+shortURL;
    }

    /**
     * Convert savedId to base-62 encoded short URL
     */
    private static String toShortURL(int savedId) {
        StringBuffer sb = new StringBuffer();

        //convert digit -> base62
        while(savedId>0){
            int x = Long.valueOf(savedId%62).intValue();
            sb.append(BASECHAR.charAt(x));
            savedId /= 62;
        }
        return sb.reverse().toString();
    }
}
