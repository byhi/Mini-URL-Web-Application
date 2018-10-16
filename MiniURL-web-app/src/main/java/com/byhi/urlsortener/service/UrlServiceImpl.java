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
public class UrlServiceImpl implements UrlService {

	@Value("${ShortUrlService.hostname}")
	private String hostname;

	private LongUrlServiceImpl longUrlService;
	private ShortUrlServiceImpl shortUrlService;

	@Autowired
	public void setLongUrlService(LongUrlServiceImpl longUrlService) {
		this.longUrlService = longUrlService;
	}

	@Autowired
	public void setShortUrlService(ShortUrlServiceImpl shortUrlService) {
		this.shortUrlService = shortUrlService;
	}

	public ArrayList<Url> giveAllUrl() {
		ArrayList<Url> urlslist = new ArrayList<Url>();
		List<Longurl> lh = longUrlService.getAllLongUrl();
		if (!lh.isEmpty()) {

			List<ShortUrl> sh = shortUrlService.getAllUrl();

			for (ShortUrl url : sh) {
				boolean b = true;
				int i = 0;
				do {
					if (url.getLongUrl().equals(lh.get(i))) {
						urlslist.add(new Url(lh.get(i).getOriginalurl(), hostname + url.getShortUrl()));
						b = false;
					}
					i++;
				} while (b);
			}
		}
		return urlslist;
	}
}
