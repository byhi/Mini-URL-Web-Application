package com.byhi.urlsortener.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.repository.ShortUrlReposiroty;

@Service
public class ShortUrlService {

	private ShortUrlReposiroty shortUrlRepository;

	@Autowired
	public void setShortUrlReposiroty(ShortUrlReposiroty shortUrlRepository) {
		this.shortUrlRepository = shortUrlRepository;
	}

	public void getAllShortUrls(Longurl longurl) {
		longurl.setSortUrlList(shortUrlRepository.findAll());
	}

	public void init(Longurl longurl, String userdefiniton) {
		ShortUrl shortUrl = shortUrlRepository.save(new ShortUrl(generateShorturl(userdefiniton, longurl.getId())));
		shortUrl.setLongUrl(longurl);
		shortUrlRepository.save(shortUrl);

	}

	public String generateShorturl(String userdefiniton, long longurlid) {
		StringBuilder stringbuilder = new StringBuilder();
		longurlid--;
		if (!userdefiniton.equals("")) {
			stringbuilder.append(userdefiniton);
			stringbuilder.append('.');
		}
		stringbuilder.append(IDConverterService.INSTANCE.createUniqueID(longurlid));
		return stringbuilder.toString();
	}

	public boolean isShortUrlExist(Longurl longurl, String userdefiniton) {
		return shortUrlRepository.findByShortUrl(generateShorturl(userdefiniton, longurl.getId())) != null ? true : false;
	}

	public String getShortUrlByLongUrl(Longurl longurl) {
		ArrayList<ShortUrl> shortUrlList = shortUrlRepository.findByShortUrlById(longurl);
		return shortUrlList.get(shortUrlList.size() - 1).getShortUrl();
	}

	public Long getShortUrlByURL(String string) {
		ShortUrl shortUrlList = shortUrlRepository.findByShortUrl(string);
		return shortUrlList == null ? null : shortUrlList.getId();
	}

	public ShortUrl getShortUrlByID(long id) {
		return shortUrlRepository.findByShortUrlById(id);
	}

	public ArrayList<ShortUrl> getAllShortUrl() {
		return shortUrlRepository.findAll();
	}

	public boolean isShortUrlExist(String url) {
		return getShortUrlByURL(url) != null;
	}

}
