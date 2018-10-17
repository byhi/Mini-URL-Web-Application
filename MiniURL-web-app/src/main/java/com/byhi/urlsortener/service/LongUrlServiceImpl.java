package com.byhi.urlsortener.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepository;

@Service
public class LongUrlServiceImpl implements LongUrlService{
	private LongUrlRepository longUrlRepository;

	@Autowired
	public void setLongUrlRepositor(LongUrlRepository longUrlRepositor) {
		this.longUrlRepository = longUrlRepositor;
	}

	public Longurl init(String url) {
		return longUrlRepository.save(new Longurl(url));		
	}

	public boolean isURLExist(String string) {
		return longUrlRepository.findByUrl(string) == null ? false : true;
	}

	public Longurl getLongurlByURL(String originalurl) {
		return longUrlRepository.findByUrl(originalurl);
	}

	public List<Longurl> getAllURL() {
		return longUrlRepository.findAll();
	}

}
