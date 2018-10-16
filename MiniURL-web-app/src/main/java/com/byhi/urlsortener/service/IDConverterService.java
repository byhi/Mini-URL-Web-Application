package com.byhi.urlsortener.service;

public interface IDConverterService {

	public String createUniqueID(Long id) ;
	public Long getDictionaryKeyFromUniqueID(String uniqueID);
}
