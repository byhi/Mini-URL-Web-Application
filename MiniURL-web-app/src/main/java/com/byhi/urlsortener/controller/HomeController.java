package com.byhi.urlsortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String urlShortener(Model model) {
		return "index";
	}
	
	
}
