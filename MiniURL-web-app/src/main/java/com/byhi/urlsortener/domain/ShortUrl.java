package com.byhi.urlsortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShortUrl {
	@GeneratedValue
	@Id
	private Long id;
	private String sortUrl;
	@ManyToOne
	private Longurl longUrl;
	
	
	public ShortUrl() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortUrl() {
		return sortUrl;
	}

	public void setSortUrl(String sortUrl) {
		this.sortUrl = sortUrl;
	}

	public Longurl getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(Longurl longUrl) {
		this.longUrl = longUrl;
	}
	
}
