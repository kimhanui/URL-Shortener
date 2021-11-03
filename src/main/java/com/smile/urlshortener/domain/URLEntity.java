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
    private String original;
    private String shorten;

    public URLEntity(String original) {
        this.original = original;
    }

    public void updateShortenUrl(String shorten) {
        this.shorten = shorten;
    }
}
