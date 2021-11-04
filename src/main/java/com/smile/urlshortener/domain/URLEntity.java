package com.smile.urlshortener.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String originalUrl;

    @Column(unique=true)
    private String shortUrl;

    public URLEntity(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void updateShortenUrl(String shorten) {
        this.shortUrl = shorten;
    }
}
