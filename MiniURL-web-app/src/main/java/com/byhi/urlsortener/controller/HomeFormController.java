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

import com.byhi.urlsortener.pojo.Formdata;
import com.byhi.urlsortener.service.LongUrlService;
import com.byhi.urlsortener.service.ShortUrlService;

@Controller
public class HomeFormController {
	@Value("${ShortUrlService.hostname}")
	private String hostname;

	private LongUrlService longUrlService;
	private ShortUrlService shortUrlService;

	@Autowired
	public void setLongUrlService(LongUrlService longUrlService) {
		this.longUrlService = longUrlService;
	}

	@Autowired
	public void setShortUrlService(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}

	@GetMapping("/generateshort")
	public String shortenerForm(Model model) {
		model.addAttribute("hostname", hostname);
		model.addAttribute("generateshort", new Formdata());
		return "generateshort";
	}

	@PostMapping("/generateshort")
	public RedirectView shortenerSubmit(@ModelAttribute Formdata formdata, Model model,
			RedirectAttributes redirectAttrs) {
		if (checkLongUrl(formdata)) {
			if (checkShortUrl(formdata)) {
				model.addAttribute("warning", "fail");
			} else {
				createShortUrl(formdata);
			}
		} else {
			createLongUrl(formdata);
		}
		redirectAttrs.addAttribute("msg", "generated");
		redirectAttrs.addFlashAttribute("formdata", formdata);
		redirectAttrs.addFlashAttribute("shortedurl", getShortUrl(formdata));

		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/{msg}");
		return redirectView;
	}

	private boolean checkShortUrl(Formdata formdata) {
		return longUrlService.isShortUrlExist(formdata.getUrl(), formdata.getUserdefiniton());
	}

	private boolean checkLongUrl(Formdata formdata) {
		return longUrlService.isUrlExist(formdata.getUrl());
	}

	private void createShortUrl(Formdata formdata) {
		longUrlService.addShortUrlforThis(formdata.getUrl(), formdata.getUserdefiniton());
	}

	private void createLongUrl(Formdata formdata) {
		longUrlService.init(formdata.getUrl(), formdata.getUserdefiniton());
	}

	private String getShortUrl(Formdata formdata) {
		return shortUrlService.getShortUrlByLongUrl(longUrlService.findByOriginalUrl(formdata.getUrl()));
	}

}
