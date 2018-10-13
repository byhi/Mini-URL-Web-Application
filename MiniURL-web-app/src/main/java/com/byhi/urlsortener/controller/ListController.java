package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.byhi.urlsortener.service.UrlService;

@Controller
public class ListController {
	private UrlService urlService;
	
	@Autowired
	public void setUrlService(UrlService urlService) {
		this.urlService = urlService;
	}

	@RequestMapping("/urllist")
	public String urlShortener(Model model) {		
		model.addAttribute("urls",  urlService.giveMeAllUrl());
		return "urllist";
	}	
}
