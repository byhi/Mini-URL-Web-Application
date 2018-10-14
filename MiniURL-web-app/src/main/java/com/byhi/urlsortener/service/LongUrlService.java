package com.byhi.urlsortener.service;

import java.util.List;
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

		Longurl longurl = longUrlRepository.save(new Longurl(url));
		sortUrlService.init(longurl, userdefiniton);
	}

	public boolean isShortUrlExist(String url, String userdefiniton) {
		return sortUrlService.isShortUrlExist(findByOriginalUrl(url), userdefiniton);
	}

	public boolean isUrlExist(String string) {
		return longUrlRepository.findByOriginalUrl(string) == null ? false : true;
	}

	public Longurl findByOriginalUrl(String originalurl) {
		return longUrlRepository.findByOriginalUrl(originalurl);
	}

	public void addShortUrlforThis(String url, String userdefiniton) {
		Longurl longurl = longUrlRepository.findByOriginalUrl(url);
		sortUrlService.init(longurl, userdefiniton);
	}

	public List<Longurl> getAllLongUrl() {
		return longUrlRepository.findAll();
	}

}
