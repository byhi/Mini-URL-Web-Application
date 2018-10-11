package com.byhi.urlsortener.repository;

import org.springframework.data.repository.CrudRepository;

import com.byhi.urlsortener.domain.ShortUrl;

public interface ShortUrlReposiroty extends CrudRepository<ShortUrl, Long> {

}
