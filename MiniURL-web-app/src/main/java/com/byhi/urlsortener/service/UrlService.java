package com.byhi.urlsortener.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.pojo.Url;

@Service
public class UrlService {
	
	@Value("${ShortUrlService.hostname}")
	private String hostname;
	
	private LongUrlService longUrlService;
	private ShortUrlService shortUrlService;
	
	@Autowired
	public void setLongUrlService(LongUrlService longUrlService) {
		this.longUrlService = longUrlService;
	}

	@Autowired
	public void setShortUrlService(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}
	
	public ArrayList<Url> giveMeAllUrl() {
		ArrayList<Url> urlslist = new ArrayList<Url>();
		List<ShortUrl> sh = shortUrlService.getAllShortUrl();
		List<Longurl> lh = longUrlService.getAllLongUrl();

		for (ShortUrl url : sh) {
			boolean b = true;
			int i= 0;
			do {
				if (url.getLongUrl().equals(lh.get(i))) {
					urlslist.add(new Url( lh.get(i).getOriginalurl(),hostname + url.getShortUrl()) );
					b=false;
				}
				i++;
			} while (b);
		}
		return urlslist;
	}
}
