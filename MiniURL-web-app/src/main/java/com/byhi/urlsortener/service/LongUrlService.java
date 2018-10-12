package com.byhi.urlsortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepository;


@Service
public class LongUrlService {
	private LongUrlRepository longUrlRepository;
	private ShortUrlService sortUrlService;	
	
	@Autowired
	public void setLongUrlRepositor(LongUrlRepository longUrlRepositor) {
		this.longUrlRepository = longUrlRepositor;		
	}
	
	@Autowired
	public void setShortUrlService(ShortUrlService sortUrlService) {
		this.sortUrlService = sortUrlService;		
	}

	public void init(String url, String userdefiniton) {
		Longurl longurl = new Longurl();
		longurl.setOriginalurl(url);
		longUrlRepository.save(longurl);
		sortUrlService.init(longurl, userdefiniton);
	}
	
	public boolean isShortUrlExist(String url, String userdefiniton) {
		Longurl longurl = findByOriginalUrl(url);
		
		return sortUrlService.isShortUrlExist(longurl, userdefiniton);
	}
	
	public boolean isUrlExist(String string) {	
			return longUrlRepository.findByOriginalUrl(string)==null ? false : true;
	}
	
	public Longurl findByOriginalUrl(String originalurl) {
		Longurl l = longUrlRepository.findByOriginalUrl(originalurl);
		return l;	
	}

	public void addShortUrlforThis(String url, String userdefiniton) {
		sortUrlService.init(longUrlRepository.findByOriginalUrl(url), userdefiniton);		
	}

}
