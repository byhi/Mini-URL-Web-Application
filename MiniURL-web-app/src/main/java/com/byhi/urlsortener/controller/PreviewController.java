package com.byhi.urlsortener.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.service.ShortUrlService;

@Controller
public class PreviewController {
	private ShortUrlService shortUrlService;

	@Autowired
	public void setShortUrlService(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}

	@GetMapping(value = "/preview")
	public String previewInit(Model model, RedirectAttributes redirectAttrs, HttpServletRequest request) {
		long id = (long) model.asMap().get("shortedurlid");
		ShortUrl shortUrl = shortUrlService.getShortUrlByID(id);
		Longurl longurl = shortUrl.getLongUrl();
		model.addAttribute("longurl", longurl.getOriginalurl());
		return "preview";
	}

}
