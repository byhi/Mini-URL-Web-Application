package com.byhi.urlsortener.service;

import java.util.ArrayList;


import com.byhi.urlsortener.domain.ShortUrl;

public interface ShortUrlService<T> {
	public void init(T t, String userdefiniton);
	public boolean isShortUrlExist(T t, String userdefiniton);	
	public String getShortUrlByLongUrl(T t);
	public Long getShortUrlByURL(String string);
	public ShortUrl getUrlByID(long id);
	public ArrayList<ShortUrl> getAllUrl();
	
}
