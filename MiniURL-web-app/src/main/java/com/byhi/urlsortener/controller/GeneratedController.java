package com.byhi.urlsortener.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GeneratedController {
	
	@Value("${ShortUrlService.hostname}")
	private String hostname;
		
	@GetMapping("/generated")
	public String genratedGet(Model model, RedirectAttributes redirectAttrs, HttpServletRequest request) {
 		model.addAttribute("shortedurl", hostname + (String) model.asMap().get("shortedurl"));
		return "generated";
	}

	

}
