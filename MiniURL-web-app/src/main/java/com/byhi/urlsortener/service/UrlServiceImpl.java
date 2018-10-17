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

	@Value("${server.path}")
	private String hostpath;

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

	public void saveURL(String url, String userdefiniton) {
		Longurl longurl = longUrlService.init(url);
		shortUrlService.init(longurl, userdefiniton);
	}

	public void addURLforThis(String url, String userdefiniton) {
		Longurl longurl = longUrlService.getLongurlByURL(url);
		shortUrlService.init(longurl, userdefiniton);
	}

	public ArrayList<Url> getAllURL() {
		ArrayList<Url> urlList = new ArrayList<Url>();
		List<Longurl> longURLList = longUrlService.getAllURL();
		if (!longURLList.isEmpty()) {
			List<ShortUrl> shortURLList = shortUrlService.getAllURL();
			for (ShortUrl url : shortURLList) {
				boolean b = true;
				int i = 0;
				do {
					if (url.getLongUrl().equals(longURLList.get(i))) {
						urlList.add(new Url(longURLList.get(i).getOriginalurl(), hostpath + url.getShortUrl()));
						b = false;
					}
					i++;
				} while (b);
			}
		}
		return urlList;
	}

}
