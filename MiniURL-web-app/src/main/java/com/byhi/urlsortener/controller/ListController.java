package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byhi.urlsortener.service.UrlService;
import com.byhi.urlsortener.service.UrlServiceImpl;

@Controller
public class ListController {
	private UrlService urlService;

	@Autowired
	public void setUrlService(UrlServiceImpl urlService) {
		this.urlService = urlService;
	}

	@RequestMapping("/urllist")
	public String urlShortener(Model model) {
		model.addAttribute("urls", urlService.getAllURL());
		return "urllist";
	}
}
