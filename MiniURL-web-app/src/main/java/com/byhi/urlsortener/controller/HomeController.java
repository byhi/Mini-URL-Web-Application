package com.byhi.urlsortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path = "/")
	public String getIndex() {
		return "index";
	}
}
