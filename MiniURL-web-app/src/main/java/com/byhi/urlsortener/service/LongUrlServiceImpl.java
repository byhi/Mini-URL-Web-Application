package com.byhi.urlsortener.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepository;

@Service
public class LongUrlServiceImpl implements LongUrlService,URLChecker{
	private LongUrlRepository longUrlRepository;
	private ShortUrlServiceImpl sortUrlService;

	@Autowired
	public void setLongUrlRepositor(LongUrlRepository longUrlRepositor) {
		this.longUrlRepository = longUrlRepositor;
	}

	@Autowired
	public void setShortUrlService(ShortUrlServiceImpl sortUrlService) {
		this.sortUrlService = sortUrlService;
	}

	public void init(String url, String userdefiniton) {

		Longurl longurl = longUrlRepository.save(new Longurl(url));
		sortUrlService.init(longurl, userdefiniton);
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
