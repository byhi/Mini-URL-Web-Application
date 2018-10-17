package com.byhi.urlsortener.service;

import com.byhi.urlsortener.domain.Longurl;

public interface LongUrlService extends URLChecker, URLList<Longurl> {

	public Longurl init(String url);

	public Longurl getLongurlByURL(String originalurl);

}
