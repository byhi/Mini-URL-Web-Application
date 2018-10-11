package com.byhi.urlsortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.service.LongUrlService;



@Controller
public class HomeFormController {
	private LongUrlService longUrlService;

	
	@Autowired
	public void setLongUrlService(LongUrlService longUrlService) {
		this.longUrlService = longUrlService;		
	}

	
	
	
   
   @GetMapping("/generatesort")
   public String greetingForm2(Model model) {
       model.addAttribute("generatesort", new Longurl());
       return "generatesort";
   }

  @PostMapping("/generatesort")
   public String greetingSubmit2(@ModelAttribute Longurl longurl) {
	  longUrlService.init(longurl);
       return "generate";
   }
}
