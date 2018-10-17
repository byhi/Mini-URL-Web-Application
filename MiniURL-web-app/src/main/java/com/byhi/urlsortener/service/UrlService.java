package com.byhi.urlsortener.service;

import com.byhi.urlsortener.pojo.Url;

public interface UrlService extends URLList<Url> {

	public void saveURL(String url, String userdefiniton);

	public void addURLforThis(String url, String userdefiniton);
}
