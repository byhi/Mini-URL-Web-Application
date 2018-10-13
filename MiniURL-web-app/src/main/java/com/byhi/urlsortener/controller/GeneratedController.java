package com.byhi.urlsortener.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.byhi.urlsortener.pojo.Formdata;
import com.byhi.urlsortener.service.ShortUrlService;

@Controller
public class GeneratedController {
	private ShortUrlService shortUrlService;
	@Autowired
	public void setShortUrlService(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}
	
	@GetMapping("/generated")
	public String genratedGet(Model model, RedirectAttributes redirectAttrs, HttpServletRequest request) {

		model.addAttribute("formdata", (Formdata) model.asMap().get("formdata"));
		
		model.addAttribute("shortedurl", (String) model.asMap().get("shortedurl"));
		model.addAttribute("shortedurlid",shortUrlService.getShortUrlByURL((String) model.asMap().get("shortedurl")));

		return "generated";
	}

	

}
