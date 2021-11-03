package com.smile.urlshortener.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLEntityRepository extends JpaRepository<URLEntity, Long> {
    Optional<URLEntity> findByOriginalUrl(String originalUrl);
    Optional<URLEntity> findByShortUrl(String shortUrl);
}
