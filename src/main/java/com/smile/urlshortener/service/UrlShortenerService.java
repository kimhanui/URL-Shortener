package com.smile.urlshortener.service;

import com.smile.urlshortener.domain.URLEntity;
import com.smile.urlshortener.domain.URLEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.PatternSyntaxException;

@Slf4j
@Service
public class UrlShortenerService {

    private URLEntityRepository urlEntityRepository;

    @Autowired
    public UrlShortenerService(URLEntityRepository urlEntityRepository){
        this.urlEntityRepository = urlEntityRepository;
    }

    /**
     * 같은 original url은 같은 shorten url을 반환한다.
     */
    @Transactional
    public String create(String originalUrl) {
        if(isAlreadyConverted(originalUrl)== true)
            throw new IllegalArgumentException("이미 변환된 url 입니다.");

        Optional<URLEntity> urlEntity = urlEntityRepository.findByOriginalUrl(originalUrl);

        if(urlEntity.isPresent()){ // 해당 shroten url 반환
            URLEntity target = urlEntity.get();
            return target.getShortUrl();
        }
        else{
            URLEntity target = new URLEntity(originalUrl);
            // entity 저장
            Integer savedId = urlEntityRepository.save(target).getId();
            log.info("savedId: " + savedId);
            // id로 short url 생성
            String shortUrl = URLUtil.createShortURL(savedId);
            log.info("shortUrl: " + shortUrl);
            // entity update
            target.updateShortenUrl(shortUrl);
            // short url 반환
            return shortUrl;
        }
    }

    @Transactional(readOnly = true)
    public String findOriginalURL(String shortUrl) throws NullPointerException{
        if(isAlreadyConverted(shortUrl)== false)
            throw new IllegalArgumentException("현 사이트에서 변환되지 않은 url 입니다.");
        URLEntity target = urlEntityRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new NullPointerException("현 사이트에서 변환되지 않은 url 입니다."));
        return target.getOriginalUrl();
    }

    /**
     * check if given url is already converted or not
     */
    private boolean isAlreadyConverted(String url) {
        String domain="";
        try {
            domain = url.split("/")[2];
        }catch(ArrayIndexOutOfBoundsException e) { // http(https)로 시작하지 않는 url
            domain = url.split("/")[0];
        }

        if(domain.equals("localhost:8080")) return true;
        return false;
    }
}
