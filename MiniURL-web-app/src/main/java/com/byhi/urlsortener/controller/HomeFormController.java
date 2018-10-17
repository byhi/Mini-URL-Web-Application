package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.pojo.Formdata;
import com.byhi.urlsortener.service.LongUrlService;
import com.byhi.urlsortener.service.LongUrlServiceImpl;
import com.byhi.urlsortener.service.ShortUrlService;
import com.byhi.urlsortener.service.ShortUrlServiceImpl;
import com.byhi.urlsortener.service.UrlService;
import com.byhi.urlsortener.service.UrlServiceImpl;

@Controller
public class HomeFormController {
	@Value("${server.path}")
	private String hostpath;

	private LongUrlService longUrlService;
	private ShortUrlService<ShortUrl, Longurl, Long> shortUrlService;
	private UrlService urlService;

	@Autowired
	public void setLongUrlService(UrlServiceImpl urlService) {
		this.urlService = urlService;
	}

	@Autowired
	public void setLongUrlService(LongUrlServiceImpl longUrlService) {
		this.longUrlService = longUrlService;
	}

	@Autowired
	public void setShortUrlService(ShortUrlServiceImpl shortUrlService) {
		this.shortUrlService = shortUrlService;
	}

	@GetMapping("/generateshort")
	public String shortenerForm(Model model) {
		model.addAttribute("hostname", hostpath);
		model.addAttribute("generateshort", new Formdata());
		return "generateshort";
	}

	@PostMapping("/generateshort")
	public RedirectView shortenerSubmit(@ModelAttribute Formdata formdata, Model model,
			RedirectAttributes redirectAttrs) {
		redirectAttrs.addAttribute("msg", "generated");
		if (checkLongUrl(formdata)) {
			if (checkShortUrl(formdata)) {
				redirectAttrs.addFlashAttribute("warning", "fail");
			} else {
				createShortUrl(formdata);
			}
		} else {
			createLongUrl(formdata);
		}

		redirectAttrs.addFlashAttribute("formdata", formdata);
		redirectAttrs.addFlashAttribute("shortedurl", getShortUrl(formdata));

		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/{msg}");
		return redirectView;
	}

	private boolean checkShortUrl(Formdata formdata) {

		return shortUrlService.isShortUrlExist(longUrlService.getLongurlByURL(formdata.getUrl()),
				formdata.getUserdefiniton());
	}

	private boolean checkLongUrl(Formdata formdata) {
		return longUrlService.isURLExist(formdata.getUrl());
	}

	private void createShortUrl(Formdata formdata) {
		urlService.addURLforThis(formdata.getUrl(), formdata.getUserdefiniton());
	}

	private void createLongUrl(Formdata formdata) {
		urlService.saveURL(formdata.getUrl(), formdata.getUserdefiniton());
	}

	private String getShortUrl(Formdata formdata) {
		return shortUrlService.getShortUrlByLongUrl(longUrlService.getLongurlByURL(formdata.getUrl()));
	}

}
