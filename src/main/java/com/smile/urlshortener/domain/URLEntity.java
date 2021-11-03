package com.smile.urlshortener.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortUrl;

    public URLEntity(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void updateShortenUrl(String shorten) {
        this.shortUrl = shorten;
    }
}
