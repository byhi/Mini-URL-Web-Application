package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.byhi.urlsortener.exception.ResourceNotFoundException;
import com.byhi.urlsortener.service.ShortUrlServiceImpl;

@Controller
public class RedirectController {
	private ShortUrlServiceImpl shortUrlService;

	@Autowired
	public void setShortUrlService(ShortUrlServiceImpl shortUrlService) {
		this.shortUrlService = shortUrlService;
	}

	@RequestMapping(path = "/{url}")
	public RedirectView redirectByURL(@PathVariable("url") String url, Model model, RedirectAttributes redirectAttrs)
			throws ResourceNotFoundException {
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		if (url.equals("")) {
			redirectView.setUrl("/index");
			return redirectView;
		} else if (shortUrlService.isURLExist(url)) {
			Long id = shortUrlService.getIDByURL(url);
			redirectAttrs.addAttribute("msg", "preview");
			redirectAttrs.addFlashAttribute("shortedurlid", id);
			redirectView.setUrl("/{msg}");
			return redirectView;
		} else {
			throw new ResourceNotFoundException();
		}
	}
}
