package com.byhi.urlsortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.repository.LongUrlRepository;
import com.byhi.urlsortener.repository.ShortUrlReposiroty;

@Service
public class LongUrlService {

	LongUrlRepository longUrlRepository;
	ShortUrlService sortUrlService;
	
	@Autowired
	public void setLongUrlRepositor(LongUrlRepository longUrlRepositor) {
		this.longUrlRepository = longUrlRepositor;		
	}
	
	@Autowired
	public void setShortUrlService(ShortUrlService sortUrlService) {
		this.sortUrlService = sortUrlService;		
	}

	
	public void init(Longurl longurl) {
		longUrlRepository.save(longurl);	
		sortUrlService.init(longurl);
	}

	public long getCout() {
		return longUrlRepository.count();
	}
}
