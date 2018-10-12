package com.byhi.urlsortener.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;

public interface ShortUrlReposiroty extends CrudRepository<ShortUrl, Long> {
	ArrayList<ShortUrl> findAll();
	
	@Query("SELECT a FROM ShortUrl a WHERE a.shortUrl=:shortUrl")
	ShortUrl findByShortUrl(@Param("shortUrl") String shortUrl);
	@Query("SELECT a FROM ShortUrl a WHERE a.longUrl =:id")
	ArrayList<ShortUrl> findByShortUrlById(@Param("id") Longurl id);
}
