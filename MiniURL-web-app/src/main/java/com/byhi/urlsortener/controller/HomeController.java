package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.byhi.urlsortener.service.ShortUrlService;

import javassist.NotFoundException;

@Controller
public class HomeController {
	
	private ShortUrlService shortUrlService;

	@Autowired
	public void setShortUrlService(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}
	
	@RequestMapping(path="/")
    public String getIndex( Model model) {
		return "index";
	}
	
	@RequestMapping(path="/{url}")
    public RedirectView getMessage(@PathVariable("url") String url, Model model,RedirectAttributes redirectAttrs) throws NotFoundException {
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
        if (url.equals("")) {        							
			redirectView.setUrl("/index");
			return redirectView;
		} else if (shortUrlService.isShortUrlExist(url)) {
			Long id = shortUrlService.getShortUrlByURL(url);
			redirectAttrs.addAttribute("msg", "preview");			
			redirectAttrs.addFlashAttribute("shortedurlid", id);			
			redirectView.setUrl("/{msg}");
			return redirectView;
		} else {			
			redirectView.setUrl("/");
			return redirectView;
		}
    }	
}
