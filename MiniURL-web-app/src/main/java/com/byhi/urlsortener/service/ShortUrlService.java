package com.byhi.urlsortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.repository.ShortUrlReposiroty;

@Service
public class ShortUrlService {
	ShortUrlReposiroty shortUrlRepository;
	
	@Autowired
	public void setShortUrlReposiroty(ShortUrlReposiroty shortUrlRepository) {
		this.shortUrlRepository = shortUrlRepository;		
	}

	public void init(Longurl longurl) {
		ShortUrl s = new ShortUrl();
		s.setLongUrl(longurl);
		s.setSortUrl(IDConverter.INSTANCE.createUniqueID(longurl.getId()));
		shortUrlRepository.save(s);		
	}
}
