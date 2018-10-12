package com.byhi.urlsortener.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.byhi.urlsortener.pojo.Formdata;
import com.byhi.urlsortener.service.LongUrlService;
import com.byhi.urlsortener.service.ShortUrlService;

@Controller
public class HomeFormController {
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

	@GetMapping("/generatesort")
	public String shortenerForm(Model model) {
		model.addAttribute("generatesort", new Formdata());
		return "generatesort";
	}

	@PostMapping("/generatesort")
	public String shortenerSubmit(@ModelAttribute Formdata formdata, Model model) {
		
		if(checkLongUrl(formdata)) {
			if (checkShortUrl(formdata)) {
				model.addAttribute("warning", "fail");
			} else {
				createShortUrl(formdata);			
			}			
		}else{
			createLongUrl(formdata);			
		}
		model.addAttribute("sortedurl", getShortUrl(formdata));
		return "generate";
	}
	
	private boolean checkShortUrl(Formdata formdata) {
		return longUrlService.isShortUrlExist(formdata.getUrl(), formdata.getUserdefiniton());
	}
	private boolean checkLongUrl(Formdata formdata) {
		return longUrlService.isUrlExist(formdata.getUrl());
	}
	
	private void createShortUrl(Formdata formdata) {
		longUrlService.addShortUrlforThis(formdata.getUrl(), formdata.getUserdefiniton());
	}
	
	private void createLongUrl(Formdata formdata) {
		longUrlService.init(formdata.getUrl(), formdata.getUserdefiniton());
	}
	private String getShortUrl(Formdata formdata) {
		return 	shortUrlService.getShortUrlByLongUrl(longUrlService.findByOriginalUrl(formdata.getUrl()));
	}
	
}
