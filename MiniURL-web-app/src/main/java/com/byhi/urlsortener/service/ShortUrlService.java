package com.byhi.urlsortener.service;

public interface ShortUrlService<E, T, N> extends URLChecker,URLList<E>{
	public void init(T t, String userdefiniton);
	public boolean isShortUrlExist(T t, String userdefiniton);	
	public String getShortUrlByLongUrl(T t);

	public N getIDByURL(String string);
	public E getUrlByID(long id);	
}
