package com.byhi.urlsortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepositor;

@Service
public class LongUrlService {

	LongUrlRepositor longUrlRepositor;
	
	@Autowired
	public void setLongUrlRepositor(LongUrlRepositor longUrlRepositor) {
		this.longUrlRepositor = longUrlRepositor;		
	}
	
	public void init(Longurl longurl) {
		longUrlRepositor.save(longurl);		
	}
}
