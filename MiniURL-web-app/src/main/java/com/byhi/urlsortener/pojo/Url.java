package com.byhi.urlsortener.pojo;

public class Url {
	private String originalurl;
	private String shorturl;

	public Url(String originalurl, String shorturl) {
		this.originalurl = originalurl;
		this.shorturl = shorturl;
	}

	public String getOriginalurl() {
		return originalurl;
	}

	public void setOriginalurl(String originalurl) {
		this.originalurl = originalurl;
	}

	public String getShorturl() {
		return shorturl;
	}

	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}

}
