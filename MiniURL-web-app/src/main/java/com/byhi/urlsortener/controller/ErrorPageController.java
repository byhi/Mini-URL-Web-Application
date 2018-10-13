package com.byhi.urlsortener.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

public class ErrorPageController implements ErrorController{

	private final static String ERROR_PATH = "/error";
	private ErrorAttributes errorAttributes;
	
	
	@Autowired
	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(ERROR_PATH)
	public String error(Model model , HttpServletRequest request , WebRequest webRequest) {	
		Map<String , Object> errorMap =  getErrorAttributes(request, webRequest, true);		
		model.addAllAttributes(errorMap);
		//System.err.println(errorMap.put(arg0, arg1));
		return "error";
	}
	
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest, boolean includeStackTrace) {

	//RequestAttributes requestAttributes = new ServletRequestAttributes(request);
	return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
	
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}


}
