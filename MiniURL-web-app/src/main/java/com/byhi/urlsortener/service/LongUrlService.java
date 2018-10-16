package com.byhi.urlsortener.service;

import java.util.List;

import com.byhi.urlsortener.domain.Longurl;

public interface LongUrlService{
	
	public void init(String url, String userdefiniton);
	public Longurl findByOriginalUrl(String originalurl);
	public void addShortUrlforThis(String url, String userdefiniton);
	public List<Longurl> getAllLongUrl();
}
