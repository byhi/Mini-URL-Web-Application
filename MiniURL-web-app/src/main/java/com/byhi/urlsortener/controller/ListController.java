package com.byhi.urlsortener.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.pojo.Url;
import com.byhi.urlsortener.service.LongUrlService;
import com.byhi.urlsortener.service.ShortUrlService;

@Controller
public class ListController {
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


	@RequestMapping("/urllist")
	public String urlShortener(Model model) {
		ArrayList<Url> uuu = giveMeAllUrl();
		System.err.println(uuu.size());
		model.addAttribute("urls", uuu);
		return "urllist";
	}

	private ArrayList<Url> giveMeAllUrl() {
		ArrayList<Url> urlslist = new ArrayList<Url>();
		List<ShortUrl> sh = shortUrlService.getAllShortUrl();
		List<Longurl> lh = longUrlService.getAllLongUrl();

		for (ShortUrl url : sh) {
			boolean b = true;
			int i= 0;
			do {
				System.out.println(i);
				if (url.getLongUrl().equals(lh.get(i))) {
					urlslist.add(new Url( lh.get(i).getOriginalurl(),url.getShortUrl()) );
					b=false;
				}
				i++;
			} while (b);
		}
		// a.add(new Url(sh.));
		return urlslist;
	}

	private ArrayList<Url> buildUrlList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
